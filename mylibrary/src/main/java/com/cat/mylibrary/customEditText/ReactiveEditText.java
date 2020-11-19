package com.cat.mylibrary.customEditText;

import android.content.Context;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.AttributeSet;

import com.cat.mylibrary.helper.HelperLink;
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
                if (!getEnteredUrl(data).isEmpty()) {
                    String url = getEnteredUrl(data);
                    sendResult(url);
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {
            }
        });
    }

    private void sendResult(String url) {
        LinkInfo linkInfo = ReactiveScraping.getLinkInfo(url);
        if (linkInfo != null) {
            getReactiveResult.getResult(linkInfo);
        } else
            getReactiveResult.noPreview();
    }

    private String getEnteredUrl(String data) {
        return HelperLink.getUrlFromText(data);
    }


    public interface GetReactiveResult {
        void getResult(LinkInfo linkInfo);
        void noPreview();
    }


    public void getResult(GetReactiveResult getReactiveResult) {
        this.getReactiveResult = getReactiveResult;
    }

}
