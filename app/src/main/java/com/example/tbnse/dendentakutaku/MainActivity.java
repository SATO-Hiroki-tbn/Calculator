package com.example.tbnse.dendentakutaku;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.HashMap;
import java.util.Map;

public class MainActivity extends Activity {

    // 計算クラスのインスタンスを取得
    final private Calculator calc = new Calculator();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // ■レイアウトオブジェクトの取得
        // ボタンをMapに格納
        final Map<String, Button> layoutObjMap = new HashMap<>() ;
        setBtnObj(layoutObjMap);

        // ■テキストオブジェクトの取得
        final TextView textView = (TextView) findViewById(R.id.text_result);
        // 初期値を設定
        textView.setText(Const.ZERO_STRING);

        // ■ボタン処理を定義
        setBtnProcs(layoutObjMap);

        // ■ディスプレイクラスにテキストビューを設定
        Display.getDisplayInstance().setTextView(textView, this);
    }

    /**
     * ボタンオブジェクト取得し、引数のMapに格納する。
     *
     * @param btnObjMap ボタンオブジェクトを格納するMap
     */
    private void setBtnObj(Map<String, Button> btnObjMap) {
        // 「C」ボタンを設定
        btnObjMap.put(BtnNameConst.BTN_C, (Button) findViewById(R.id.button_clear));
        // 「+/-」ボタンを設定
        btnObjMap.put(BtnNameConst.BTN_PLS_MNS, (Button) findViewById(R.id.button_pls_mns));
        // 「%」ボタンを設定
        btnObjMap.put(BtnNameConst.BTN_MOD, (Button) findViewById(R.id.button_mod));
        // 「÷」ボタンを設定
        btnObjMap.put(BtnNameConst.BTN_DIVIDE, (Button) findViewById(R.id.button_div));
        // 「×」ボタンを設定
        btnObjMap.put(BtnNameConst.BTN_MULTIPLE, (Button) findViewById(R.id.button_mul));
        // 「-」ボタンを設定
        btnObjMap.put(BtnNameConst.BTN_MINUS, (Button) findViewById(R.id.button_minus));
        // 「+」ボタンを設定
        btnObjMap.put(BtnNameConst.BTN_PLUS, (Button) findViewById(R.id.button_plus));
        // 「=」ボタンを設定
        btnObjMap.put(BtnNameConst.BTN_EQUAL, (Button) findViewById(R.id.button_equal));
        // 「.」ボタンを設定
        btnObjMap.put(BtnNameConst.BTN_DECIMAL_POINT, (Button) findViewById(R.id.button_decimal_point));
        // 「1」ボタンを設定
        btnObjMap.put(BtnNameConst.BTN_ONE, (Button) findViewById(R.id.button_1));
        // 「2」ボタンを設定
        btnObjMap.put(BtnNameConst.BTN_TWO, (Button) findViewById(R.id.button_2));
        // 「3」ボタンを設定
        btnObjMap.put(BtnNameConst.BTN_THREE, (Button) findViewById(R.id.button_3));
        // 「4」ボタンを設定
        btnObjMap.put(BtnNameConst.BTN_FOUR, (Button) findViewById(R.id.button_4));
        // 「5」ボタンを設定
        btnObjMap.put(BtnNameConst.BTN_FIVE, (Button) findViewById(R.id.button_5));
        // 「6」ボタンを設定
        btnObjMap.put(BtnNameConst.BTN_SIX, (Button) findViewById(R.id.button_6));
        // 「7」ボタンを設定
        btnObjMap.put(BtnNameConst.BTN_SEVEN, (Button) findViewById(R.id.button_7));
        // 「8」ボタンを設定
        btnObjMap.put(BtnNameConst.BTN_EIGHT, (Button) findViewById(R.id.button_8));
        // 「9」ボタンを設定
        btnObjMap.put(BtnNameConst.BTN_NINE, (Button) findViewById(R.id.button_9));
        // 「0」ボタンを設定
        btnObjMap.put(BtnNameConst.BTN_ZERO, (Button) findViewById(R.id.button_0));
    }


    /**
     * 各ボタンの処理を定義する
     *
     * @param btnObjMap ボタンオブジェクトを格納したMap
     */
    private void setBtnProcs(Map<String, Button> btnObjMap) {

        // 「C」ボタン処理
        btnObjMap.get(BtnNameConst.BTN_C).setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                calc.onCBtn();
            }
        });

        // 「+/-」ボタン処理
        btnObjMap.get(BtnNameConst.BTN_PLS_MNS).setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                calc.onPlsMnsBtn();
            }
        });

        // 「%」ボタン処理
        btnObjMap.get(BtnNameConst.BTN_MOD).setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                calc.onOpeBtn(Const.OPE_SYM_REMINDER);
            }
        });

        // 「÷」ボタン処理
        btnObjMap.get(BtnNameConst.BTN_DIVIDE).setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                calc.onOpeBtn(Const.OPE_SYM_DIVIDE);
            }
        });

        // 「×」ボタン処理
        btnObjMap.get(BtnNameConst.BTN_MULTIPLE).setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                calc.onOpeBtn(Const.OPE_SYM_MULTIPLE);
            }
        });

        // 「-」ボタン処理
        btnObjMap.get(BtnNameConst.BTN_MINUS).setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                calc.onOpeBtn(Const.OPE_SYM_MINUS);
            }
        });

        // 「+」ボタン処理
        btnObjMap.get(BtnNameConst.BTN_PLUS).setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                calc.onOpeBtn(Const.OPE_SYM_PLUS);
            }
        });

        // 「=」ボタン処理
        btnObjMap.get(BtnNameConst.BTN_EQUAL).setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                calc.onEqualBtn();
            }
        });

        // 「.」ボタン処理
        btnObjMap.get(BtnNameConst.BTN_DECIMAL_POINT).setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                calc.onDecimalPointBtn();
            }
        });

        // 「1」ボタン処理
        btnObjMap.get(BtnNameConst.BTN_ONE).setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                calc.onNumBtn(Const.ONE_STRING);
            }
        });

        // 「2」ボタン処理
        btnObjMap.get(BtnNameConst.BTN_TWO).setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                calc.onNumBtn(Const.TWO_STRING);
            }
        });

        // 「3」ボタン処理
        btnObjMap.get(BtnNameConst.BTN_THREE).setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                calc.onNumBtn(Const.THREE_STRING);
            }
        });

        // 「4」ボタン処理
        btnObjMap.get(BtnNameConst.BTN_FOUR).setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                calc.onNumBtn(Const.FOUR_STRING);
            }
        });

        // 「5」ボタン処理
        btnObjMap.get(BtnNameConst.BTN_FIVE).setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                calc.onNumBtn(Const.FIVE_STRING);
            }
        });

        // 「6」ボタン処理
        btnObjMap.get(BtnNameConst.BTN_SIX).setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                calc.onNumBtn(Const.SIX_STRING);
            }
        });

        // 「7」ボタン処理
        btnObjMap.get(BtnNameConst.BTN_SEVEN).setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                calc.onNumBtn(Const.SEVEN_STRING);
            }
        });

        // 「8」ボタン処理
        btnObjMap.get(BtnNameConst.BTN_EIGHT).setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                calc.onNumBtn(Const.EIGHT_STRING);
            }
        });

        // 「9」ボタン処理
        btnObjMap.get(BtnNameConst.BTN_NINE).setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                calc.onNumBtn(Const.NINE_STRING);
            }
        });

        // 「0」ボタン処理
        btnObjMap.get(BtnNameConst.BTN_ZERO).setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                calc.onNumBtn(Const.ZERO_STRING);
            }
        });
    }
}