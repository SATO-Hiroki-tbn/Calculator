package com.example.tbnse.dendentakutaku;

import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by tbnse on 2017/06/17.
 */

public class Display {

    // 計算クラスのインスタンス(シングルトン)
    private static Display dispInstance = null;

    // テキストビュー
    private TextView textView = null;

    // コンテキスト(Toast表示用)
    protected android.content.Context parent;

    /**
     * コンストラクタ
     */
    private Display() {}


    /**
     * インスタンスのゲッター
     */
    public static Display getDisplayInstance() {
        if(dispInstance == null) {
            dispInstance = new Display();
        }
        return dispInstance;
    }

    /**
     * テキストビューのセッター
     */
    void setTextView(TextView textView, android.content.Context context) {
        this.textView = textView;
        this.parent = context;
    }

    /**
     * 末尾に入力値を追加する
     */
    void addImputVal(String val) {

        // 表示中の値を取得
        StringBuffer sb = new StringBuffer(textView.getText().toString());
        // ケタ数チェック
        if (!isOverMaxDigit(sb.toString())) {
            // 桁数が上限を超えている場合、処理なし
            return;
        }

        // 表示中の値が「0」、かつ入力値が「小数点」でない場合、ブランクに置換する
        if(Const.ZERO_STRING.equals(sb.toString())
                && !Const.DECIMAL_POINT_STRING.equals(val)) {
            sb.replace(0, 1, Const.DEFAULT_STRING_EMPTY);
        }
        // 末尾に引数の文字列を連結し、テキストビューに設定
        textView.setText(sb.append(val).toString());
    }

    /**
     * ディスプレイをクリアする
     */
    void clearDisplay() {
        textView.setText(Const.ZERO_STRING);
    }

    /**
     * 表示中の値を取得する
     */
    String getViewVal() {
        return textView.getText().toString();
    }

    /**
     * ディスプレイのケタ数をチェックする
     *  True: 全体のケタ数が最大15桁未満
     *  False: 全体のケタ数が最大15桁以上
     * 　　　　または、小数点以下が最大10桁を超える
     *  ※先頭のマイナス符号は含めず、小数点は1桁に含める
     */
     boolean isOverMaxDigit(String val) {
         // 先頭にマイナス符号が存在する場合、ブランクに置換する
         if(val.startsWith(Const.OPE_SYM_MINUS)) {
             val.replace(Const.OPE_SYM_MINUS, Const.DEFAULT_STRING_EMPTY);
         }

         // 全体のケタ数が15桁以上の場合、エラー
         if(val.length() >= Const.MAX_DIGIT) {
             Toast.makeText(parent, ErrMsgConst.ERR_MSG_OVER_MAX_DIGIT, Toast.LENGTH_SHORT).show();
             return false;
         }

         // 文字列に小数点が存在する場合のみ、処理を行う
         if(val.contains(Const.DECIMAL_POINT_STRING)) {
             // 小数部の文字列を取得
             String decimal = val.substring(val.indexOf(Const.DECIMAL_POINT_STRING));
             // 数点以下の桁数が10桁以上の場合、エラー
             if (decimal.length() >= Const.MAX_DIGIT_DECIMAL) {
                 Toast.makeText(parent, ErrMsgConst.ERR_MSG_OVER_MAX_DIGIT_DECIMAL, Toast.LENGTH_SHORT).show();
                 return false;
             }
         }

         return true;
     }
}