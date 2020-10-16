package com.news.lyt.utils;

import cn.hutool.extra.qrcode.BufferedImageLuminanceSource;
import com.google.zxing.*;
import com.google.zxing.common.HybridBinarizer;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.EnumMap;

public class ZXingCodeDecodeUtils {

    // 二维码格式参数
    private static final EnumMap<DecodeHintType, Object> decodeHints = new EnumMap<DecodeHintType, Object>(
            DecodeHintType.class);
    static {
        decodeHints.put(DecodeHintType.CHARACTER_SET, "UTF-8");
    }

    /**
     * 解析文件
     *
     * @param args
     */
    public static String decodeCodeFile(String path) {
        File file = new File(path);
        if (file.exists()) {
            // 把文件转成图片对象
            try {
                String content = decodeCodeStream(new FileInputStream(file));
                return content;
            } catch (Exception e) {
                e.printStackTrace();
                return null;
            }

        } else {
            return null;
        }
    }

    /**
     * 解析流
     *
     * @param args
     */
    public static String decodeCodeStream(InputStream is) {
        if (null != is) {
            try {
                BufferedImage image = ImageIO.read(is);
                LuminanceSource source = new BufferedImageLuminanceSource(image);
                Binarizer binarizer = new HybridBinarizer(source);
                BinaryBitmap binaryBitmap = new BinaryBitmap(binarizer);
                MultiFormatReader reader = new MultiFormatReader();
                Result result = reader.decode(binaryBitmap, decodeHints);
                String content = result.getText();
                return content;
            } catch (Exception e) {
                e.printStackTrace();
                return null;
            }
        }
        return null;
    }

    public static void main(String[] args) throws FileNotFoundException {
        //方式1，文件路径方式
        //String string = decodeCodeFile("D:/xiaotian.gif");
        //方式2，流的方式
        String string = decodeCodeStream(new FileInputStream(new File("D:/xiaotian.gif")));
        System.out.println(string);
    }
}
