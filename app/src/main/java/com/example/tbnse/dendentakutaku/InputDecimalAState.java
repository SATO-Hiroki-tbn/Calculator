package com.example.tbnse.dendentakutaku;

/**
 * Created by tbnse on 2017/06/17.
 */

public class InputDecimalAState implements State {

    // 小数入力A状態クラスのインスタンス(シングルトン)
    private static InputDecimalAState inputDecimalAStateInstance = new InputDecimalAState();

    /**
     * コンストラクタ
     */
    private InputDecimalAState() {}

    /**
     * インスタンスのゲッター
     */
    public static State getInputDecimalAStateInstance() {
        return inputDecimalAStateInstance;
    }

    @Override
    public void onNumBtn(Context context, String inputNum) {
        // 入力値をディスプレイに反映
        context.setValDisplay(inputNum);

        // 状態遷移(⇨InputDecimalAState)
        context.changeState(inputDecimalAStateInstance);
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
