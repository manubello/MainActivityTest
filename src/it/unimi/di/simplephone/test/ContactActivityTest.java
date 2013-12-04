package it.unimi.di.simplephone.test;

import it.unimi.di.simplephone.CallActivity;
import it.unimi.di.simplephone.ContactActivity;
import it.unimi.di.simplephone.MainActivity;
import it.unimi.di.simplephone.R;
import android.content.Intent;
import android.test.ActivityUnitTestCase;
import android.test.ViewAsserts;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class ContactActivityTest  extends ActivityUnitTestCase<ContactActivity> {

	private ContactActivity mContactActivity;
    private View mContactActivityTest;
    private TextView mInfoTextView;
    private TextView mInfoContactName;   
    

    final EditText viewText = (EditText) 
    		mContactActivity.findViewById(R.id.textView1);
    

    final EditText Text = (EditText) 
    		mContactActivity.findViewById(R.id.contact_name);
    
	public ContactActivityTest(Class<ContactActivity> activityClass) {
		super(activityClass);
		// TODO Auto-generated constructor stub
	}
	
	protected void setUp() throws Exception{ //setup
		
		super.setUp();
		
		mInfoTextView = (TextView) mContactActivity.findViewById(R.id.textView1);
		mInfoContactName = (TextView) mContactActivity.findViewById(R.id.contact_name);
		    
		mContactActivity = getActivity();
		 
		mContactActivityTest = (View) mContactActivity.findViewById(R.id.listView1);
		
		Intent nLaunchIntent = new Intent(getInstrumentation().getTargetContext(),MainActivity.class);
		startActivity(nLaunchIntent,null,null);
		
		//mactivityClass = getActivity();
		
		//mClickMeButton
		//mInfoTextView = (Textview) mClickFunActivity.FindView.id.infoText
	}
/*
	public void testInfoTextView_layout() {
    final View decorView = mClickFunActivity.getWindow().getDecorView();
    ViewAsserts.assertOnScreen(decorView, mInfoTextView);
    assertTrue(View.GONE == mInfoTextView.getVisibility());
}*/
	
	public void testContactView_layout() throws Exception {
		
		final View decorView = mContactActivity.getWindow().getDecorView();
		ViewAsserts.assertOnScreen(decorView,  mContactActivityTest);
	}

public void testInfoTextView_layout() throws Exception {
		
		final View decorView = mContactActivity.getWindow().getDecorView();
		ViewAsserts.assertOnScreen(decorView,  mInfoTextView);
	}

public void testInfoContactName_layout() throws Exception {
	
	final View decorView = mContactActivity.getWindow().getDecorView();
	ViewAsserts.assertOnScreen(decorView,  mInfoTextView);
}
}

