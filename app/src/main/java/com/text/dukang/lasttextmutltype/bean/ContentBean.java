package com.text.dukang.lasttextmutltype.bean;

import java.util.List;

/**
 * @Author : wdk
 * @Email :a15939582085@126.com
 * Created on : 2017/2/16 15:41
 * @Description :
 */

public class ContentBean {

    /**
     * abtest : 0
     * bannerList : [{"content":"http://sale.feiniu.com/m-48714/android/CS000016","contentId":"48714","desc":"20","endTime":"","picUrl":"http://img03.fn-mart.com/C/web/layout/kk/20160804/201608041448161470293296_kk-1.jpg.webp","startTime":"","title":"1","type":21},{"content":"http://sale.feiniu.com/m-45839/android/CS000016","contentId":"45839","desc":"20","endTime":"","picUrl":"http://img02.fn-mart.com/C/web/layout/kk/20160802/201608021444121470120252_kk-1.jpg.webp","startTime":"","title":"2","type":21},{"content":"http://sale.feiniu.com/m-49811/android/CS000016","contentId":"49811","desc":"20","endTime":"","picUrl":"http://img01.fn-mart.com/C/web/layout/kk/20160801/201608011553521470038032_kk-1.jpg.webp","startTime":"","title":"3","type":21},{"content":"http://sale.feiniu.com/m-49350/android/CS000016","contentId":"49350","desc":"20","endTime":"","picUrl":"http://img05.fn-mart.com/C/web/layout/kk/20160801/201608011554271470038067_kk-1.jpg.webp","startTime":"","title":"4","type":21},{"content":"http://sale.feiniu.com/m-49854/android/CS000016","contentId":"49854","desc":"20","endTime":"","picUrl":"http://img03.fn-mart.com/C/web/layout/kk/20160801/201608011555421470038142_kk-1.jpg.webp","startTime":"","title":"5","type":21},{"content":"http://sale.feiniu.com/m-48650/android/CS000016","contentId":"48650","desc":"20","endTime":"","picUrl":"http://img06.fn-mart.com/C/web/layout/kk/20160801/201608011555061470038106_kk-1.jpg.webp","startTime":"","title":"6","type":21},{"content":"http://sale.feiniu.com/m-48600/android/CS000016","contentId":"48600","desc":"20","endTime":"","picUrl":"http://img06.fn-mart.com/C/web/layout/kk/20160802/201608020840371470098437_kk-1.jpg.webp","startTime":"","title":"7","type":21},{"content":"http://sale.feiniu.com/m-49656/android/CS000016","contentId":"49656","desc":"20","endTime":"","picUrl":"http://img05.fn-mart.com/C/web/layout/kk/20160801/201608011559121470038352_kk-1.jpg.webp","startTime":"","title":"8","type":21},{"content":"http://sale.feiniu.com/m-48974/android/CS000016","contentId":"48974","desc":"20","endTime":"","picUrl":"http://img04.fn-mart.com/C/web/layout/kk/20160805/201608051511251470381085_kk-1.jpg.webp","startTime":"","title":"9","type":21},{"content":"http://sale.feiniu.com/m-45242/android/CS000016","contentId":"45242","desc":"20","endTime":"","picUrl":"http://img01.fn-mart.com/C/web/layout/kk/20160805/201608050944551470361495_kk-1.jpg.webp","startTime":"","title":"10","type":21}]
     * isBlank : 0
     * layout : 0
     * seckill : {}
     * subTitle :
     * title :
     * type : 1
     * url :
     * urlType : 0
     */

    private String abtest;
    private int isBlank;
    private int layout;
    private SeckillBean seckill;
    private String subTitle;
    private String title;
    private int type;
    private String url;
    private int urlType;
    private List<BannerListBean> bannerList;

    public String getAbtest() {
        return abtest;
    }

    public void setAbtest(String abtest) {
        this.abtest = abtest;
    }

    public int getIsBlank() {
        return isBlank;
    }

    public void setIsBlank(int isBlank) {
        this.isBlank = isBlank;
    }

    public int getLayout() {
        return layout;
    }

    public void setLayout(int layout) {
        this.layout = layout;
    }

    public SeckillBean getSeckill() {
        return seckill;
    }

    public void setSeckill(SeckillBean seckill) {
        this.seckill = seckill;
    }

    public String getSubTitle() {
        return subTitle;
    }

    public void setSubTitle(String subTitle) {
        this.subTitle = subTitle;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public int getUrlType() {
        return urlType;
    }

    public void setUrlType(int urlType) {
        this.urlType = urlType;
    }

    public List<BannerListBean> getBannerList() {
        return bannerList;
    }

    public void setBannerList(List<BannerListBean> bannerList) {
        this.bannerList = bannerList;
    }

    public static class SeckillBean {
    }

    public static class BannerListBean {
        /**
         * content : http://sale.feiniu.com/m-48714/android/CS000016
         * contentId : 48714
         * desc : 20
         * endTime :
         * picUrl : http://img03.fn-mart.com/C/web/layout/kk/20160804/201608041448161470293296_kk-1.jpg.webp
         * startTime :
         * title : 1
         * type : 21
         */

        private String content;
        private String contentId;
        private String desc;
        private String endTime;
        private String picUrl;
        private String startTime;
        private String title;
        private int type;

        public Pic getPic() {
            return pic;
        }

        public void setPic(Pic pic) {
            this.pic = pic;
        }

        private Pic pic;

        public String getContent() {
            return content;
        }

        public void setContent(String content) {
            this.content = content;
        }

        public String getContentId() {
            return contentId;
        }

        public void setContentId(String contentId) {
            this.contentId = contentId;
        }

        public String getDesc() {
            return desc;
        }

        public void setDesc(String desc) {
            this.desc = desc;
        }

        public String getEndTime() {
            return endTime;
        }

        public void setEndTime(String endTime) {
            this.endTime = endTime;
        }

        public String getPicUrl() {
            return picUrl;
        }

        public void setPicUrl(String picUrl) {
            this.picUrl = picUrl;
        }

        public String getStartTime() {
            return startTime;
        }

        public void setStartTime(String startTime) {
            this.startTime = startTime;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public int getType() {
            return type;
        }

        public void setType(int type) {
            this.type = type;
        }

        public class Pic{
            private String normal;
            private String pressed;

            public String getNormal() {
                return normal;
            }

            public void setNormal(String normal) {
                this.normal = normal;
            }

            public String getPressed() {
                return pressed;
            }

            public void setPressed(String pressed) {
                this.pressed = pressed;
            }
        }
    }
}
