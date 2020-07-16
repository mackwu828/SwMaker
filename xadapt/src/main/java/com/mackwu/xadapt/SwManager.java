package com.mackwu.xadapt;

public class SwManager {

    private static SwManager instance = null;

    private SwManager() {
    }

    public static SwManager getInstance() {
        if (instance == null) {
            synchronized (SwManager.class) {
                if (instance == null) {
                    instance = new SwManager();
                }
            }
        }
        return instance;
    }


    /**
     * 设计图尺寸=1080x1920
     *
     * 分辨率=1920x1080，dpi=320 => sw=540
     * 分辨率=1920x1080，dpi=340 => sw=540
     * 分辨率=1920x1080，dpi=360 => sw=540
     * 分辨率=1920x1080，dpi=400 => sw=540
     * 分辨率=1920x1080，dpi=420 => sw=540
     * 分辨率=1920x1080，dpi=440 => sw=540
     * 分辨率=1920x1080，dpi=450 => sw=540
     * 分辨率=1920x1080，dpi=480 => sw=540
     * 分辨率=1920x1080，dpi=560 => sw=540
     * 分辨率=1920x1080，dpi=640 => sw=540
     *
     * 分辨率=1920x1080，dpi=120 => sw=1080
     * 分辨率=1920x1080，dpi=160 => sw=1080
     * 分辨率=1920x1080，dpi=213 => sw=1080
     * 分辨率=1920x1080，dpi=240 => sw=1080
     * 分辨率=1920x1080，dpi=260 => sw=1080
     * 分辨率=1920x1080，dpi=280 => sw=1080
     * 分辨率=1920x1080，dpi=300 => sw=1080
     *
     */
    public void makeDesignWidth1080(){
        SwMaker swMaker = new SwMaker.Builder()
                .designWidth(1080)
                .moduleName("app")
                .swValues(new int[]{540})
                .build();
        swMaker.makeAllDimens();
    }
}
