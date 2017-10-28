package com.example.tbnse.dendentakutaku;

/**
 * Created by tbnse on 2017/06/17.
 */

public interface State {

    /**
     * 数値ボタン押下処理
     */
    void onNumBtn(Context context, String inputNum);

    /**
     * 四則演算ボタン押下処理
     */
    void onOpeBtn(Context context, String inputOpe);

    /**
     * =ボタン押下処理
     */
    void onEqualBtn(Context context);

    /**
     * Cボタン押下処理
     */
    void onCBtn(Context context);

    /**
     * ACボタン押下処理
     */
    void onAllCBtn(Context context);

    /**
     * 小数点ボタン押下処理
     */
    void onDecimalPointBtn(Context context);

    /**
     * +/-ボタン押下処理
     */
    void onPlsMnsBtn(Context context);

}
