package com.example.tbnse.dendentakutaku;

import android.widget.Toast;

import java.math.BigDecimal;

/**
 * Created by tbnse on 2017/04/22.
 */
public class Calculator implements Context{

    // 変数A
    private String numA;
    // 変数B
    private String numB;
    // 演算子
    private String opeSym;
    // ディスプレイクラスのインスタンス(シングルトン)
    private Display display = Display.getDisplayInstance();
    // 状態(初期状態：数値入力A)
    private State state;

    /**
     * コンストラクタ
     */
    public Calculator() {

        // 変数A
        numA = Const.DEFAULT_STRING_EMPTY;
        // 変数B
        numB = Const.DEFAULT_STRING_EMPTY;
        // 演算子
        opeSym = Const.DEFAULT_STRING_EMPTY;
        // 状態を設定
        changeState(InputNumAState.getInputNumAStateInstance());
        // ディスプレのインスタンスを取得
        display = Display.getDisplayInstance();
    }

    /**
     * 数値ボタン押下処理の呼び出し
     */
    public void onNumBtn(String num) {
        state.onNumBtn(this, num);
    }

    /**
     * 四則演算ボタン押下処理の呼び出し
     */
    public void onOpeBtn(String opeSym) {
        state.onOpeBtn(this, opeSym);
    }

    /**
     * =ボタン押下処理の呼び出し
     */
    public void onEqualBtn() {
        state.onEqualBtn(this);
    }

    /**
     * Cボタン押下処理の呼び出し
     */
    public void onCBtn() {
        state.onCBtn(this);
    }

    /**
     * ACボタン押下処理の呼び出し
     */
    public void onAllCBtn() {
        state.onAllCBtn(this);
    }

    /**
     * 小数点ボタン押下処理
     */
    public void onDecimalPointBtn() {
        state.onDecimalPointBtn(this);
    }

    /**
     * +/-ボタン押下処理
     */
    public void onPlsMnsBtn() {
        state.onPlsMnsBtn(this);
    }

    @Override
    public String getOpeSym() {
        return opeSym;
    }

    @Override
    public void setErrMsg(String errMsg) {
        if (display.parent != null) {
            Toast.makeText(display.parent, errMsg, Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void changePlsMns() {
        // ディスプレイから値を取得
        BigDecimal temp = new BigDecimal(display.getViewVal().toString());
        // 「-1」をかける
        BigDecimal result = temp.multiply(new BigDecimal(Const.MINUS_ONE_STRING));
        // 結果をディスプレイに設定
        display.clearDisplay();
        display.addImputVal(result.toString());
    }

    @Override
    public void changeState(State state) {
        // 状態遷移
        this.state = state;
    }

    @Override
    public void doOperation() {
        // 変数A, 変数BをBigDecimal型へ変換
        BigDecimal bdA = new BigDecimal(numA);
        BigDecimal bdB = new BigDecimal(numB);
        BigDecimal tempResult = null;
        String result;

        // 演算子ごとに処理を行う
        switch(opeSym) {
            // "+"
            case Const.OPE_SYM_PLUS:
                tempResult = bdA.add(bdB);
                break;
            // "-"
            case Const.OPE_SYM_MINUS:
                tempResult = bdA.subtract(bdB);
                break;
            // "×"
            case Const.OPE_SYM_MULTIPLE:
                tempResult = bdA.multiply(bdB);
                break;
            // "÷"
            case Const.OPE_SYM_DIVIDE:
                if(Const.ZERO_STRING.equals(numB)) {
                    // 0割はエラー
                    setErrMsg(ErrMsgConst.ERR_MSG_ZERO_DIVISION);
                    return;
                }
                tempResult = bdA.divide(bdB);
                break;
            // "%"
            case Const.OPE_SYM_REMINDER:
                tempResult = bdA.remainder(bdB);
                break;
            // その他
            default:
                // 処理なし
        }
        result = tempResult.stripTrailingZeros().toString();
        // 結果をディスプレイに反映
        display.clearDisplay();
        display.addImputVal(result);
    }

    @Override
    public void setValDisplay(String val) {
        display.addImputVal(val);
    }

    @Override
    public void clearDisplay() {
        display.clearDisplay();
    }

    @Override
    public void setNumA() {
        numA = display.getViewVal();
    }

    @Override
    public void setNumB() {
        numB = display.getViewVal();
    }

    @Override
    public void clearNumA() { numA = Const.DEFAULT_STRING_EMPTY; }

    @Override
    public void clearNumB() {
        numB = Const.DEFAULT_STRING_EMPTY;
    }

    @Override
    public void setOpeSym(String opeSym) {
        this.opeSym = opeSym;
    }
}
