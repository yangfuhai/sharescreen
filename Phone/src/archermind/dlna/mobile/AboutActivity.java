package archermind.dlna.mobile;

import android.app.Activity;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;

public class AboutActivity extends Activity {
	
	private static final String TAG = "AboutActivity";
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		Log.d(TAG, "onCreate: ");
		
		setContentView(R.layout.about_layout);
		
		findViewById(R.id.btn_left_top).setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				finish();
			}
		});
		
		try {
			String versionName = getPackageManager().getPackageInfo(getPackageName(), 0).versionName;
			((TextView)findViewById(R.id.version)).setText(versionName);
		} catch (NameNotFoundException e) {
		}
		
		TextView temp = (TextView) findViewById(R.id.title);
		temp.setText(R.string.about_title);
		
		TextView version = (TextView) findViewById(R.id.version);
		TextView channelCode = (TextView) findViewById(R.id.channel_code);
		version.setText(getVersion());
		channelCode.setText(getChannelCode());
		
	}
	
	public String getVersion() {
		try {
	         PackageManager manager = this.getPackageManager();
	         PackageInfo info = manager.getPackageInfo(this.getPackageName(), 0);
	         String version = info.versionName;
	         return version;
	     } catch (Exception e) {
	         e.printStackTrace();
	         return "";
	     }
	}

	public String getChannelCode() {
		return 0+"";
	}
}
