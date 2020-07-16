package com.mackwu.xadapt;

import java.io.File;
import java.io.FileOutputStream;
import java.math.BigDecimal;
import java.util.Locale;

public class SwMaker {

    private int designWidth;
    private String moduleName;
    private int[] swValues;
    private int[] dpiValues = new int[]{120, 160, 213, 240, 260, 280, 300, 320, 340, 360, 400, 420, 440, 450, 480, 560, 640};

    public SwMaker(Builder builder) {
        this.designWidth = builder.designWidth;
        this.moduleName = builder.moduleName;
        this.swValues = builder.swValues;
    }

    public static final class Builder {
        private int designWidth;
        private String moduleName;
        private int[] swValues;

        public Builder designWidth(int designWidth) {
            this.designWidth = designWidth;
            return this;
        }

        public Builder moduleName(String moduleName) {
            this.moduleName = moduleName;
            return this;
        }

        public Builder swValues(int[] swValues) {
            this.swValues = swValues;
            return this;
        }

        public SwMaker build() {
            return new SwMaker(this);
        }
    }


    /**
     * 计算最小宽度。
     *
     */
    public void calculateSw(){
        for (int dpiValue : dpiValues) {

        }
    }

    public void makeAllDimens() {
        try {
            for (int swValue : swValues) {
                // modulePath
                String modulePath = new File("").getCanonicalPath() + "/" + moduleName + "/src/main/res";
                // dirPath
                String dirPath = modulePath + "/values-sw" + swValue + "dp";
                File dirFile = new File(dirPath);
                if (!dirFile.exists()) {
                    dirFile.mkdirs();
                }

                //
                FileOutputStream fos = new FileOutputStream(dirPath + "/dimens.xml");
                StringBuilder sb = new StringBuilder();
                sb.append("<?xml version=\"1.0\" encoding=\"utf-8\"?>\r\n")
                        .append("<resources>\r\n")
                        .append(String.format(Locale.getDefault(), "   <string name=\"design_width\">%dpx</string>\r\n", designWidth))
                        .append(String.format(Locale.getDefault(), "   <string name=\"current_sw\">%ddp</string>\r\n", swValue));

                // dp
                for (int i = -50; i < 1920; i++) {
                    float dpValue = i / (float) designWidth * swValue;
                    BigDecimal bigDecimal = new BigDecimal(dpValue);
                    bigDecimal.setScale(4, BigDecimal.ROUND_HALF_UP);
                    if (i < 0) {
                        sb.append(String.format(Locale.getDefault(), "   <dimen name=\"_dp_%2$d\">%3$.4fdp</dimen>\r\n", "", i * -1, dpValue));
                    } else {
                        sb.append(String.format(Locale.getDefault(), "   <dimen name=\"dp_%2$d\">%3$.4fdp</dimen>\r\n", "", i, dpValue));
                    }
                }

                // sp
                for (int i = 0; i < 120; i++) {
                    float spValue = i / (float) designWidth * swValue;
                    BigDecimal bigDecimal = new BigDecimal(spValue);
                    bigDecimal.setScale(4, BigDecimal.ROUND_HALF_UP);
                    sb.append(String.format(Locale.getDefault(),"   <dimen name=\"sp_%2$d\">%3$.4fsp</dimen>\r\n", "", i, spValue));
                }

                sb.append("</resources>\r\n");

                fos.write(sb.toString().getBytes());
                fos.flush();
                fos.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
