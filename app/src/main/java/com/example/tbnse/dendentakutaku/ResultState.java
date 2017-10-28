package com.example.tbnse.dendentakutaku;

/**
 * Created by tbnse on 2017/06/17.
 */

public class ResultState implements State {

    // 結果表示状態クラスのインスタンス(シングルトン)
    private static ResultState inputResultStateInstance = new ResultState();

    /**
     * コンストラクタ
     */
    private ResultState() {}

    /**
     * インスタンスのゲッター
     */
    public static State getResultStateInstance() {
        return inputResultStateInstance;
    }

    @Override
    public void onNumBtn(Context context, String inputNum) {
        // ディスプレイをクリア
        context.clearDisplay();
        // 入力値をディスプレイに反映
        context.setValDisplay(inputNum);

        // 状態遷移(⇨InputNumAState)
        context.changeState(InputNumAState.getInputNumAStateInstance());
    }

    @Override
    public void onOpeBtn(Context context, String inputOpe) {
        // ディスプレイの数値を変数Aに格納
        context.setNumA();
        // 演算子を変数OpeSymに格納
        context.setOpeSym(inputOpe);

        // 状態遷移(⇨InputOpeState)
        context.changeState(InputOpeState.getInputOpeStateInstance());
    }

    @Override
    public void onEqualBtn(Context context) {
        // 処理なし

        // 状態遷移(⇨ResultState)
        context.changeState(inputResultStateInstance);
    }

    @Override
    public void onCBtn(Context context) {
        // ディスプレイをクリア
        context.clearDisplay();
        // 変数Aをクリア
        context.clearNumA();
        // 変数Bをクリア
        context.clearNumB();

        // 状態遷移(⇨InputNumAState)
        context.changeState(InputNumAState.getInputNumAStateInstance());
    }

    @Override
    public void onAllCBtn(Context context) {
        // ディスプレイをクリア
        context.clearDisplay();
        // 変数Aをクリア
        context.clearNumA();
        // 変数Bをクリア
        context.clearNumB();

        // 状態遷移(⇨InputNumAState)
        context.changeState(InputNumAState.getInputNumAStateInstance());
    }

    @Override
    public void onDecimalPointBtn(Context context) {
        // ディスプレイの値(演算結果)を変数Aに格納
        context.setNumA();
        // ディスプレイをクリア
        context.clearDisplay();
        // 「'0.'」をディスプレイに反映
        context.setValDisplay(Const.ZERO_STRING + Const.DECIMAL_POINT_STRING);

        // 状態遷移(⇨ResultState)
        context.changeState(InputDecimalBState.getInputDecimalBStateInstance());
    }

    @Override
    public void onPlsMnsBtn(Context context) {
        // ディスプレイの数値の符号を切り替える
        context.changePlsMns();

        // 状態遷移(⇨ResultState)
        context.changeState(inputResultStateInstance);
    }
}
