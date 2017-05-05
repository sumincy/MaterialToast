package com.sumincy.materialtoast;

/*
 * Copyright 2017 shan yong
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

import android.content.Context;
import android.support.annotation.StyleRes;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;
import android.widget.TextView;
import android.widget.Toast;

import java.lang.reflect.Field;

/**
 * Based on {@link android.widget.Toast}
 *
 * @author sumincy
 */

public class MToast {

    private static Toast mToast;
    private static StyleLoader styleLoader = new StyleLoader();

    public static MToast makeText(Context context, CharSequence text) {
        return makeText(context, text, R.style.defalut_style, Toast.LENGTH_SHORT);
    }

    public static MToast makeText(Context context, CharSequence text, @StyleRes int style) {
        return makeText(context, text, style, Toast.LENGTH_SHORT);
    }

    public static MToast makeText(Context context, CharSequence text, @StyleRes int style, int duration) {
        MToast toast = new MToast();
        cancelToast();
        StyleLoader.StyleAttrs attrs = styleLoader.load(context, style);
        View view = LayoutInflater.from(context).inflate(attrs.layout, null);
        view.setBackgroundResource(attrs.background);
        view.setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN);
        if (mToast == null) {
            mToast = new Toast(context);
            initMaterialToast(mToast, attrs.animationStyle);
        }
        mToast.setDuration(duration);
        mToast.setView(view);
        mToast.setGravity(attrs.gravity, 0, 0);
        TextView tv = (TextView) view.findViewById(android.R.id.message);

        if (tv != null) {
            tv.setTextSize(attrs.textSize);
            tv.setTextColor(attrs.textColor);
            tv.setText(text);
        } else {
            Log.e("MToast", " you should defined a view_id as android.R.id.message for the message textview ");
        }

        return toast;
    }

    private static void initMaterialToast(Toast toast, int style) {
        try {
            Field mTN = toast.getClass().getDeclaredField("mTN");
            mTN.setAccessible(true);
            Object mTNObj = mTN.get(toast);
            Field mParams = mTNObj.getClass().getDeclaredField("mParams");
            mParams.setAccessible(true);
            WindowManager.LayoutParams params = (WindowManager.LayoutParams) mParams.get(mTNObj);
            params.width = WindowManager.LayoutParams.MATCH_PARENT;
            params.height = WindowManager.LayoutParams.WRAP_CONTENT;
            params.windowAnimations = style;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void show() {
        mToast.show();
    }

    public static void cancelToast() {
        if (mToast != null) {
            mToast.cancel();
            mToast = null;
        }
    }

}
