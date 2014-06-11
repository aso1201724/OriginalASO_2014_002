package jp.ac.st.asojuku.original2014002;

import android.app.Activity;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends Activity implements View.OnClickListener {

	SQLiteDatabase sdb = null;
	MySQLiteOpenHelper helper = null;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	}



	@Override
	protected void onResume() {
		// TODO 自動生成されたメソッド・スタブ
				super.onResume();

				Button btn1 = (Button)findViewById(R.id.btn1);
				//ボタン変数にリスナーを登録する
				btn1.setOnClickListener(this);

				Button btn2 = (Button)findViewById(R.id.btn2);
				//ボタン変数にリスナーを登録する
				btn2.setOnClickListener(this);

				Button btn3 = (Button)findViewById(R.id.btn3);
				//ボタン変数にリスナーを登録する
				btn3.setOnClickListener(this);

				if(sdb == null) {
					helper = new MySQLiteOpenHelper(getApplicationContext());
				}
				try{
					sdb = helper.getWritableDatabase();
				}catch(SQLiteException e){
					return;
				}
	}



	@Override
	public void onClick(View v) {
		// TODO 自動生成されたメソッド・スタブ
		Intent intent = null;
		switch(v.getId()) { //どのボタンが押されたか判定
		case R.id.btn1: //binOKが押された
			//インテントのインスタンス生成
			intent = new Intent(MainActivity.this, MaintenanceActivity.class);
			//次画面のアクティビティ起動
			startActivity(intent);
			break;
		case R.id.btn2://登録
			EditText etv = (EditText)findViewById(R.id.edtMsg);
			String inputMsg = etv.getText().toString();

			if(inputMsg!=null && !inputMsg.isEmpty()){
				helper.insertHitokoto(sdb,  inputMsg);
			}
			etv.setText("");
			break;
		case R.id.btn3://チェック

			String strHitokoto = helper.selectRandomHitokoto(sdb);

			//インテントのインスタンス生成
			intent = new Intent(MainActivity.this, HitokotoActivity.class);

			intent.putExtra("hitokoto", strHitokoto);
			//次画面のアクティビティ起動
			startActivity(intent);
			break;
		}

	}


	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
