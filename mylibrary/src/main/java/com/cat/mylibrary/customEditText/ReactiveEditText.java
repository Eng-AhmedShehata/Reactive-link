package com.cat.mylibrary.customEditText;

import android.content.Context;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.AttributeSet;

import com.cat.mylibrary.models.LinkInfo;
import com.cat.mylibrary.scraping.ReactiveScraping;

public class ReactiveEditText extends androidx.appcompat.widget.AppCompatEditText {

    private GetReactiveResult getReactiveResult;

    public ReactiveEditText(Context context, AttributeSet attrs) {
        super(context, attrs);
        addListener();
    }

    private void addListener() {
        addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                String data = charSequence.toString();
                // TODO(omar & mariem) ADD method to extract url from the entered text
                if (!getEnteredUrl(data).isEmpty()) {
                    String url = getEnteredUrl(data);
                    LinkInfo linkInfo = ReactiveScraping.getLinkInfo(url);
                    getReactiveResult.getResult(linkInfo);
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {
            }
        });
    }

    private String getEnteredUrl(String data) {
        // edfewd erewr
        /*
        reresfsdf
        sdfsdfsd
        dsf
         */
        return "";
    }


    public interface GetReactiveResult {
        void getResult(LinkInfo linkInfo);
    }


    public void getResult(GetReactiveResult getReactiveResult) {
        this.getReactiveResult = getReactiveResult;
    }

}
