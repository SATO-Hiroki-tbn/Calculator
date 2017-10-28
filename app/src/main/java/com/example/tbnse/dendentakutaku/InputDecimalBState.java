package com.example.tbnse.dendentakutaku;

/**
 * Created by tbnse on 2017/06/17.
 */

public class InputDecimalBState implements State {

    // 小数入力B状態クラスのインスタンス(シングルトン)
    private static InputDecimalBState inputDecimalBStateInstance = new InputDecimalBState();

    /**
     * コンストラクタ
     */
    private InputDecimalBState() {}

    /**
     * インスタンスのゲッター
     */
    public static State getInputDecimalBStateInstance() {
        return inputDecimalBStateInstance;
    }

    @Override
    public void onNumBtn(Context context, String inputNum) {
        // 入力値をディスプレイに反映
        context.setValDisplay(inputNum);

        // 状態遷移(⇨InputDecimalBState)
        context.changeState(inputDecimalBStateInstance);
    }

    @Override
    public void onOpeBtn(Context context, String inputOpe) {
        // ディスプレイの数値を変数Bに格納
        context.setNumB();
        // 「変数A 演算子 変数B」の結果をディスプレイに反映
        context.doOperation();
        // 演算結果を変数Aに格納
        context.setNumA();
        // 演算子を変数OpeSymに格納
        context.setOpeSym(inputOpe);

        // 状態遷移(⇨InputOpeState)
        context.changeState(InputOpeState.getInputOpeStateInstance());
    }

    @Override
    public void onEqualBtn(Context context) {
        // ディスプレイの数値を変数Bに格納
        context.setNumB();
        // 「変数A 演算子 変数B」の結果をディスプレイに反映
        context.doOperation();

        // 状態遷移(⇨ResultState)
        context.changeState(ResultState.getResultStateInstance());
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
        // 処理なし
    }

    @Override
    public void onPlsMnsBtn(Context context) {
        // ディスプレイの数値の符号を切り替える
        context.changePlsMns();

        // 状態遷移(⇨InputNumAState)
        context.changeState(InputNumAState.getInputNumAStateInstance());
    }
}
