package com.text.dukang.lasttextmutltype.bean;

import java.util.List;

/**
 * @Author : wdk
 * @Email :a15939582085@126.com
 * Created on : 2017/2/16 15:38
 * @Description :
 */

public class Body {

    private List<AdvertKeywordsBean> advertKeywords;
    private List<ContentBean> content;
    private List<SearchDefaultBean> searchDefault;

    public List<AdvertKeywordsBean> getAdvertKeywords() {
        return advertKeywords;
    }

    public void setAdvertKeywords(List<AdvertKeywordsBean> advertKeywords) {
        this.advertKeywords = advertKeywords;
    }

    public List<ContentBean> getContent() {
        return content;
    }

    public void setContent(List<ContentBean> content) {
        this.content = content;
    }

    public List<SearchDefaultBean> getSearchDefault() {
        return searchDefault;
    }

    public void setSearchDefault(List<SearchDefaultBean> searchDefault) {
        this.searchDefault = searchDefault;
    }

}
