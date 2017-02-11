package cn.bproject.neteasynews.activity;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import cn.bproject.neteasynews.R;

/**
 * Created by liaozhoubei on 2017/1/5.
 */

public class FeedbackActivity extends Activity implements View.OnClickListener{

    private EditText subject_edit_text; // 邮件主题
    private EditText contact_information_edit_text;  // 联系方式
    private EditText feedback_edit_view;    // 反馈信息

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feedback);
        initView();
    }

    private void initView(){
        subject_edit_text = (EditText) findViewById(R.id.subject_edit_text);
        contact_information_edit_text = (EditText) findViewById(R.id.contact_information_edit_text);
        feedback_edit_view = (EditText) findViewById(R.id.feedback_edit_view);
        Button send_button = (Button) findViewById(R.id.send_button);
        send_button.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.send_button:
                String subject = subject_edit_text.getText().toString();
                String contact_information = contact_information_edit_text.getText().toString();
                String feedback = feedback_edit_view.getText().toString();
                if (!TextUtils.isEmpty(subject) ||  !TextUtils.isEmpty(feedback)){
                    if (!TextUtils.isEmpty(contact_information)){
                        feedback = "联系方式：" + contact_information + "反馈信息：" +feedback;
                    }
                    Intent data=new Intent(Intent.ACTION_SENDTO);
                    data.setData(Uri.parse("mailto:lzb19890920@gmail.com"));
                    data.putExtra(Intent.EXTRA_SUBJECT, subject);
                    data.putExtra(Intent.EXTRA_TEXT, feedback);
                    startActivity(data);
                    finish();
                }

                break;
            default:
                break;
        }
    }
}
