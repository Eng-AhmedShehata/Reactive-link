package com.cat.mylibrary.customEditText;

import android.content.Context;
import android.util.AttributeSet;

public class ReactiveEditText extends androidx.appcompat.widget.AppCompatEditText {

    private GetReactiveResult getReactiveResult;

    public ReactiveEditText(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    interface GetReactiveResult {
        // TODO(Mariem) add a method that return an object of type LinkInfo
    }

    // TODO(Mariem) add a method that accept an object of type GetReactiveResult


}
