package jp.suntech.s21009.myconstraintlayoutsample;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        BtLis listener = new BtLis();

        Button btconfirm = findViewById(R.id.btConfirm);
        Button btclear = findViewById(R.id.btClear);
        Button btsend = findViewById(R.id.btSend);

        btconfirm.setOnClickListener(listener);
        btclear.setOnClickListener(listener);
        btsend.setOnClickListener(listener);
    }
//
    private class BtLis implements View.OnClickListener{
        @Override
        public void onClick(View view){

            EditText etN = findViewById(R.id.etName);
            EditText etMT = findViewById(R.id.etMailTitle);
            EditText etM = findViewById(R.id.etMail);
            EditText etC = findViewById(R.id.etComment);

            String Name = etN.getText().toString();
            String MailT = etMT.getText().toString();
            String Mail = etM.getText().toString();
            String Comment = etC.getText().toString();

            String show = "名前：" + Name+"\nタイトル：" + MailT+"\nメールアドレス：" + Mail+"\n質問内容：" + Comment;

            OrderConfirmDialogFragment dialogFragment = new OrderConfirmDialogFragment();

            int id = view.getId();
            switch(id){
                case R.id.btClear:
                    etN.setText("");
                    etM.setText("");
                    etMT.setText("");
                    etC.setText("");
                    break;
                case R.id.btConfirm:
                    dialogFragment.show(getSupportFragmentManager(), "OrderConfirmDialogFragment");
                    Toast.makeText(MainActivity.this,show,Toast.LENGTH_LONG).show();
                    break;
                case R.id.btSend:
                    Toast.makeText(MainActivity.this,show,Toast.LENGTH_LONG).show();
                    break;
            }
        }
    }
}