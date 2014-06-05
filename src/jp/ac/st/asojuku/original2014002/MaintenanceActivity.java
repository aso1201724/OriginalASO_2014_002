package jp.ac.st.asojuku.original2014002;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MaintenanceActivity extends Activity implements View.OnClickListener {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO 自動生成されたメソッド・スタブ
		super.onCreate(savedInstanceState);
		setContentView(R.layout.maintenance);
	}

	@Override
	public void onClick(View v) {
		// TODO 自動生成されたメソッド・スタブ

		Intent intent = null;
		switch(v.getId()) { //どのボタンが押されたか判定
		case R.id.mbtn1: //binOKが押された
			//インテントのインスタンス生成
			intent = new Intent(MaintenanceActivity.this, MainActivity.class);
			//次画面のアクティビティ起動
			startActivity(intent);
			break;
		case R.id.mbtn2:
			break;

		}

	}

	@Override
	protected void onResume() {
		// TODO 自動生成されたメソッド・スタブ
		super.onResume();

		Button btn1 = (Button)findViewById(R.id.mbtn1);
		//ボタン変数にリスナーを登録する
		btn1.setOnClickListener(this);

		Button btn2 = (Button)findViewById(R.id.mbtn2);
		//ボタン変数にリスナーを登録する
		btn2.setOnClickListener(this);
	}

}
