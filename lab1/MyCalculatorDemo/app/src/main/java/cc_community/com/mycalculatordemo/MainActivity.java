package cc_community.com.mycalculatordemo;

import android.annotation.TargetApi;
import android.os.Build;
import android.speech.tts.TextToSpeech;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.*;

@TargetApi(Build.VERSION_CODES.DONUT)
public class MainActivity extends AppCompatActivity implements View.OnClickListener, TextToSpeech.OnInitListener{

    static Button btn_0;
    static Button btn_1;
    static Button btn_2;
    static Button btn_3;
    static Button btn_4;
    static Button btn_5;
    static Button btn_6;
    static Button btn_7;
    static Button btn_8;
    static Button btn_9;
    static Button btn_point;
    static Button btn_clear;
    static Button btn_delete;
    static Button btn_multiply;
    static Button btn_divide;
    static Button btn_plus;
    static Button btn_minus;
    static Button btn_equal;
    static EditText et_input;
    static boolean clear_flag = true;
    static double preview = 0.0;
    static boolean preflag = false;//true代表有之前缓存  false没有上一步缓存
    static Button speechBtn; // 按钮控制开始朗读
    static TextToSpeech textToSpeech; // TTS对象

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //绑定控件
        btn_0 = (Button) findViewById(R.id.btn_0);
        btn_1 = (Button) findViewById(R.id.btn_1);
        btn_2 = (Button) findViewById(R.id.btn_2);
        btn_3 = (Button) findViewById(R.id.btn_3);
        btn_4 = (Button) findViewById(R.id.btn_4);
        btn_5 = (Button) findViewById(R.id.btn_5);
        btn_6 = (Button) findViewById(R.id.btn_6);
        btn_7 = (Button) findViewById(R.id.btn_7);
        btn_8 = (Button) findViewById(R.id.btn_8);
        btn_9 = (Button) findViewById(R.id.btn_9);
        btn_clear = (Button) findViewById(R.id.btn_clear);
        btn_delete = (Button) findViewById(R.id.btn_delete);
        btn_divide = (Button) findViewById(R.id.btn_divide);
        btn_equal = (Button) findViewById(R.id.btn_equal);
        btn_minus = (Button) findViewById(R.id.btn_minus);
        btn_multiply = (Button) findViewById(R.id.btn_multiply);
        btn_plus = (Button) findViewById(R.id.btn_plus);
        btn_point = (Button) findViewById(R.id.btn_point);
        et_input = (EditText) findViewById(R.id.et_input);
        textToSpeech = new TextToSpeech(this, this); // 参数Context,TextToSpeech.OnInitListener
        //设置监听器
        btn_0.setOnClickListener(this);
        btn_1.setOnClickListener(this);
        btn_2.setOnClickListener(this);
        btn_3.setOnClickListener(this);
        btn_4.setOnClickListener(this);
        btn_5.setOnClickListener(this);
        btn_6.setOnClickListener(this);
        btn_7.setOnClickListener(this);
        btn_8.setOnClickListener(this);
        btn_9.setOnClickListener(this);
        btn_clear.setOnClickListener(this);
        btn_delete.setOnClickListener(this);
        btn_divide.setOnClickListener(this);
        btn_equal.setOnClickListener(this);
        btn_point.setOnClickListener(this);
        btn_plus.setOnClickListener(this);
        btn_multiply.setOnClickListener(this);
        btn_minus.setOnClickListener(this);

        //接口回调方式
//        btn_minus.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//            }
//        });

    }

    //委托代理
    @Override
    public void onClick(View v)
    {
        boolean speechflag = false;
        String speechTxt; // 需要朗读的内容
        speechTxt = "";
        String str = et_input.getText().toString();
        switch (v.getId())
        {
            case R.id.btn_0:
                if(!speechflag)
                {
                    speechTxt = "0";
                    speechflag = true;
                }
            case R.id.btn_1:
                if(!speechflag)
                {
                    speechTxt = "1";
                    speechflag = true;
                }
            case R.id.btn_2:
                if(!speechflag)
                {
                    speechTxt = "";
                    speechTxt = "2";
                    speechflag = true;
                }
            case R.id.btn_3:
                if(!speechflag)
                {
                    speechTxt = "";
                    speechTxt = "3";
                    speechflag = true;
                }
            case R.id.btn_4:
                if(!speechflag)
                {
                    speechTxt = "";
                    speechTxt = "4";
                    speechflag = true;
                }
            case R.id.btn_5:
                if(!speechflag)
                {
                    speechTxt = "";
                    speechTxt = "5";
                    speechflag = true;
                }
            case R.id.btn_6:
                if(!speechflag)
                {
                    speechTxt = "";
                    speechTxt = "6";
                    speechflag = true;
                }
            case R.id.btn_7:
                if(!speechflag)
                {
                    speechTxt = "";
                    speechTxt = "7";
                    speechflag = true;
                }
            case R.id.btn_8:
                if(!speechflag)
                {
                    speechTxt = "";
                    speechTxt = "8";
                    speechflag = true;
                }
            case R.id.btn_9:
                if(!speechflag)
                {
                    speechTxt = "";
                    speechTxt = "9";
                    speechflag = true;
                }
            case R.id.btn_point:
                if(!speechflag)
                {
                    speechTxt = "";
                    speechTxt = "point";
                    speechflag = true;
                }
                System.out.println(speechTxt+"!!!!!!!!");
                if(clear_flag)
                {
                    clear_flag = false;
                    str = "";
                    et_input.setText("");
                }
                et_input.setText(str+((Button)v).getText());
                if (textToSpeech != null && !textToSpeech.isSpeaking()) {
                    textToSpeech.setPitch(1);// 设置音调，值越大声音越尖（女生），值越小则变成男声,1.0是常规
                    textToSpeech.speak(speechTxt,
                            TextToSpeech.QUEUE_ADD, null);
                    speechTxt = "";
                    System.out.println("进入发声"+speechTxt);
                }
                break;
            case R.id.btn_plus:
                if(!speechflag)
                {
                    speechTxt = "";
                    speechTxt = "+";
                    speechflag = true;
                }
            case R.id.btn_minus:
                if(!speechflag)
                {
                    speechTxt = "";
                    speechTxt = "minus";
                    speechflag = true;
                }
            case R.id.btn_multiply:
                if(!speechflag)
                {
                    speechTxt = "";
                    speechTxt = "multiply";
                    speechflag = true;
                }
            case R.id.btn_divide:
                if(!speechflag)
                {
                    speechTxt = "";
                    speechTxt = "divide";
                    speechflag = true;
                }
                if (textToSpeech != null && !textToSpeech.isSpeaking()) {
                    textToSpeech.setPitch(0.0f);// 设置音调，值越大声音越尖（女生），值越小则变成男声,1.0是常规
                    textToSpeech.speak(speechTxt,
                            TextToSpeech.QUEUE_ADD, null);
                }
                if(preflag==true&&clear_flag==true)
                {
                    clear_flag = false;
                    preflag = true;
                    str = Double.toString(preview);
                    et_input.setText(str+((Button)v).getText());
                    preview = 0.0;
                }
                else
                {
                    if(clear_flag)
                    {
                        clear_flag = false;
                        str = "";
                        et_input.setText("");
                    }
                    et_input.setText(str+((Button)v).getText());
                }
                break;
            case R.id.btn_delete:
                if(!speechflag)
                {
                    speechTxt = "";
                    speechTxt = "delete";
                    speechflag = true;
                }
                if(clear_flag)
                {
                    clear_flag = false;
                    str = "";
                    et_input.setText("");
                }
                else if(str!=null && !str.equals(""))
                {
                    et_input.setText(str.substring(0,str.length()-1));
                }
                if (textToSpeech != null && !textToSpeech.isSpeaking()) {
                    textToSpeech.setPitch(0.0f);// 设置音调，值越大声音越尖（女生），值越小则变成男声,1.0是常规
                    textToSpeech.speak(speechTxt,
                            TextToSpeech.QUEUE_ADD, null);
                }
                break;
            case R.id.btn_clear:
                if(!speechflag)
                {
                    speechTxt = "";
                    speechTxt = "clear";
                    speechflag = true;
                }
                clear_flag = false;
                str = "";
                et_input.setText("");
                preview = 0.0;
                preflag = false;
            case R.id.btn_equal:
                if(!speechflag)
                {
                    speechTxt = "";
                    speechTxt = "equal";
                    speechflag = true;
                }
                if (textToSpeech != null && !textToSpeech.isSpeaking()) {
                    textToSpeech.setPitch(0.0f);// 设置音调，值越大声音越尖（女生），值越小则变成男声,1.0是常规
                    textToSpeech.speak(speechTxt,
                            TextToSpeech.QUEUE_ADD, null);
                }
                getResult(null);

                break;
        }
    }
    static double getResult(String str)
    {
        String exp = "";
        if(str!=null)
        {
            exp=str;
            //System.out.println(exp.toString()+"!!!!!!!!");
            List<Object> list = toSuffix(exp);
            Double answer =calculate(list);
           return answer;
        }
        else
        {
             exp = et_input.getText().toString();
            //System.out.println(exp.toString()+"!!!!!!!!");
            if(exp==null || exp.equals(""))
            {
                return 0;
            }
            if(clear_flag)
            {
                clear_flag = false;
                return 0;
            }
            clear_flag = true;
            String s1 = null;
            double result = 0;
            List<Object> list = toSuffix(exp);
            Double answer =calculate(list);
            exp = String.valueOf(answer);
            System.out.println(exp);
            String line[] = exp.split("\\.");
            System.out.println(line.length);
            if(line[1].equals("0"))
            {
                et_input.setText(line[0]);
                preview = answer;
                preflag = true;
                textToSpeech.speak(line[0],
                        TextToSpeech.QUEUE_ADD, null);
                return Double.parseDouble(line[0]);
            }
            else
            {
                et_input.setText(exp);
                preview = result;
                preflag = true;
                textToSpeech.speak(exp.toString(),
                        TextToSpeech.QUEUE_ADD, null);
                return Double.parseDouble(exp);
            }
        }



    }
    static List<Object> toSuffix(String s) {
        Map<String, Integer> map = new HashMap<String, Integer>();
        map.put("+", 0);
        map.put("-", 0);
        map.put("×", 1);
        map.put("÷", 1);
        List<Object> list = new ArrayList<Object>();
        String[] number = s.split("[\\+\\-\\×\\÷]");
        String[] operator = s.split("([1-9]\\d*\\.?\\d*)|(0\\.\\d*[1-9])");
        Stack<String> stack = new Stack<String>();
        for (int i = 0; i < number.length; i++) {
            if (operator[i].length() != 0) {
                while (!stack.isEmpty()
                        && map.get(operator[i]) <= map.get(stack.peek())) {
                    list.add(stack.pop());
                }
                stack.push(operator[i]);
            }
            list.add(Double.parseDouble(number[i]));
        }
        while (!stack.isEmpty()) {
            list.add(stack.pop());
        }
        return list;
    }

    static double calculate(List<Object> list) {
        Stack<Double> stack = new Stack<Double>();
        for (Object obj : list) {
            if (obj instanceof Double) {
                stack.push((Double) obj);
            } else {
                double b = stack.pop();
                double a = stack.pop();
                if (obj.equals("+"))
                    stack.push(a + b);
                if (obj.equals("-"))
                    stack.push(a - b);
                if (obj.equals("×"))
                    stack.push(a * b);
                if (obj.equals("÷"))
                    stack.push(a / b);
            }
        }
        return stack.pop();
    }

    /**
     * 用来初始化TextToSpeech引擎
     * status:SUCCESS或ERROR这2个值
     * setLanguage设置语言，帮助文档里面写了有22种
     * TextToSpeech.LANG_MISSING_DATA：表示语言的数据丢失。
     * TextToSpeech.LANG_NOT_SUPPORTED:不支持
     */
    @Override
    public void onInit(int status) {
        if (status == TextToSpeech.SUCCESS) {
            int result = textToSpeech.setLanguage(Locale.ENGLISH);
            if (result == TextToSpeech.LANG_MISSING_DATA
                    || result == TextToSpeech.LANG_NOT_SUPPORTED) {
                Toast.makeText(this, "数据丢失或不支持", Toast.LENGTH_SHORT).show();
            }
        }
    }
}
