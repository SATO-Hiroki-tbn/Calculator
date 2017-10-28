package com.example.tbnse.dendentakutaku;

/**
 * Created by tbnse on 2017/06/17.
 */

public class InputOpeState implements State {

    // 演算子入力状態クラスのインスタンス(シングルトン)
    private static InputOpeState inputOpeStateInstance = new InputOpeState();

    /**
     * コンストラクタ
     */
    private InputOpeState() {}

    /**
     * インスタンスのゲッター
     */
    public static State getInputOpeStateInstance() {
        return inputOpeStateInstance;
    }

    @Override
    public void onNumBtn(Context context, String inputNum) {

        // ディスプレイをクリア
        context.clearDisplay();
        // 入力値をディスプレイに反映
        context.setValDisplay(inputNum);

        // 状態遷移(⇨InputNumBState)
        context.changeState(InputNumBState.getInputNumBStateInstance());
    }

    @Override
    public void onOpeBtn(Context context, String inputOpe) {
        // 演算子を変数OpeSymに格納
        context.setOpeSym(inputOpe);

        // 状態遷移(⇨InputOpeState)
        context.changeState(inputOpeStateInstance);
    }

    @Override
    public void onEqualBtn(Context context) {
        // エラー「無効な式です」
        context.setErrMsg(ErrMsgConst.ERR_MSG_INVALID_OPE);
    }

    @Override
    public void onCBtn(Context context) {
        // ディスプレイをクリア
        context.clearDisplay();
        // 変数Aをクリア
        context.clearNumA();

        // 状態遷移(⇨InputNumAState)
        context.changeState(InputNumAState.getInputNumAStateInstance());
    }

    @Override
    public void onAllCBtn(Context context) {
        // ディスプレイをクリア
        context.clearDisplay();
        // 変数Aをクリア
        context.clearNumA();

        // 状態遷移(⇨InputNumAState)
        context.changeState(InputNumAState.getInputNumAStateInstance());
    }

    @Override
    public void onDecimalPointBtn(Context context) {
        // ディスプレイをクリア
        context.clearDisplay();
        // 「'0.'」をディスプレイに反映
        context.setValDisplay(Const.ZERO_STRING + Const.DECIMAL_POINT_STRING);

        // 状態遷移(⇨InputDecimalBState)
        context.changeState(InputDecimalBState.getInputDecimalBStateInstance());
    }

    @Override
    public void onPlsMnsBtn(Context context) {
        // ディスプレイの数値の符号を切り替える
        context.changePlsMns();

        // 状態遷移(⇨InputOpeState)
        context.changeState(inputOpeStateInstance);
    }
}
