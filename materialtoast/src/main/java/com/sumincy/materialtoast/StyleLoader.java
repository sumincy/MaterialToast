package com.sumincy.materialtoast;

import android.content.Context;
import android.content.res.TypedArray;
import android.support.annotation.NonNull;
import android.support.annotation.StyleRes;
import android.view.Gravity;


public class StyleLoader {
    private Context context;

    public static class StyleAttrs {
        public int background;
        public int layout;
        public int textColor;
        public int textSize;
        public int gravity;
        public int animationStyle;
    }

    public StyleAttrs load(Context context, @StyleRes int styleResId) {
        this.context = context;
        final TypedArray styledAttributes = context.obtainStyledAttributes(styleResId, R.styleable.MaterialToast);
        return load(styledAttributes);
    }

    @NonNull
    private StyleAttrs load(TypedArray styledAttributes) {
        StyleAttrs styleAttrs = new StyleAttrs();
        try {
            styleAttrs.textColor = styledAttributes.getColor(R.styleable.MaterialToast_android_textColor, context.getResources().getColor((android.R.color.white)));
            styleAttrs.textSize = styledAttributes.getDimensionPixelSize(R.styleable.MaterialToast_android_textSize, 14);
            styleAttrs.layout = styledAttributes.getResourceId(R.styleable.MaterialToast_android_layout, R.layout.material_toast);
            styleAttrs.background = styledAttributes.getResourceId(R.styleable.MaterialToast_android_background, R.drawable.black_background);
            styleAttrs.gravity = styledAttributes.getInt(R.styleable.MaterialToast_android_gravity, Gravity.TOP);
            styleAttrs.animationStyle = styledAttributes.getResourceId(R.styleable.MaterialToast_animationStyle, R.style.toastAnimation);
        } finally {
            styledAttributes.recycle();
        }
        return styleAttrs;
    }
}
