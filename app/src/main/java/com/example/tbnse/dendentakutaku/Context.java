package com.example.tbnse.dendentakutaku;

/**
 * Created by tbnse on 2017/06/17.
 */

public interface Context {
    /**
     * 引数の状態に遷移する
     */
    void changeState(State state);

    /**
     * 演算を行い、結果をディスプレイに反映する
     */
    void doOperation();

    /**
     * 入力値をディスプレイに反映する
     */
        void setValDisplay(String val);

    /**
     * ディスプレイをクリアする
     */
    void clearDisplay();

    /**
     * ディスプレイの値を変数Aに保持する
     */
    void setNumA();

    /**
     * ディスプレイの値を変数Bに保持する
     */
    void setNumB();

    /**
     * 変数Aをクリアする
     */
    void clearNumA();

    /**
     * 変数Bをクリアする
     */
    void clearNumB();

    /**
     * 演算子を設定する
     */
    void setOpeSym(String opeSym);

    /**
     * 演算子を取得する
     */
    String getOpeSym();

    /**
     * エラーメッセージを表示する
     */
    void setErrMsg(String errMsg);

    /**
     * +/-符号を反転する
     */
    void changePlsMns();
}
