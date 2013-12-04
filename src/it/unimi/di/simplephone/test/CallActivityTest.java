package it.unimi.di.simplephone.test;

import it.unimi.di.simplephone.CallActivity;
import it.unimi.di.simplephone.MainActivity;
import it.unimi.di.simplephone.R;
import it.unimi.di.simplephone.R.id;
import android.content.Intent;
import android.net.Uri.Builder;
import android.test.ActivityUnitTestCase;
import android.test.TouchUtils;
import android.test.ViewAsserts;
import android.test.suitebuilder.annotation.MediumTest;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

public class CallActivityTest extends ActivityUnitTestCase<CallActivity>{

	private CallActivity mCallActivity;
    private View mCallActivityTest;
	private Object mSendActivity;


	final TextView moutpuTextView = (TextView) 
	    		mCallActivity.findViewById(R.id.outputData);
	
	final EditText meditNumberPhoneText = (EditText) 
    		mCallActivity.findViewById(R.id.editNumberPhone);
	
	final ListView mlistViewView = (ListView) 
    		mCallActivity.findViewById(R.id.listView1);
  
    final Button mcallButton = (Button) 
    		mCallActivity.findViewById(it.unimi.di.simplephone.R.id.buttonCall);

	
	public CallActivityTest(Class<CallActivity> activityClass) {
		super(activityClass);
		// TODO Auto-generated constructor stub
	}

	protected void setUp() throws Exception{ //setup
		super.setUp();
		mCallActivity = getActivity();
		 
		mCallActivityTest = (View) mCallActivity.findViewById(id.listView1);
		
		Intent nLaunchIntent = new Intent(getInstrumentation().getTargetContext(),MainActivity.class);
		startActivity(nLaunchIntent,null,null);
	}	
	
	 public void testNoSelectableItems() throws Exception {
	
	        
	    }

	public void testSendButton_layout() throws Exception {
		Boolean nCreateOptionsMenu = mCallActivity.onCreateOptionsMenu(null);
		//ViewAsserts.assertOnScreen(decordView,  mClickMeButton);
		//assertNotNull(layaoutParams);
		//assertEquals(WindowsManager.LayaoutParams.WRAP_CONTENT, layaoutParams.height);
		
		
	}
	@MediumTest
    public void testClickMeButton_layout() {
        //Retrieve the top-level window decor view
        final View decorView = mCallActivity.getWindow().getDecorView();

        //Verify that the mClickMeButton is on screen
        ViewAsserts.assertOnScreen(decorView, mcallButton);

        //Verify width and heights
        final ViewGroup.LayoutParams layoutParams = mcallButton.getLayoutParams();
        assertNotNull(layoutParams);
        assertEquals(layoutParams.width, WindowManager.LayoutParams.MATCH_PARENT);
        assertEquals(layoutParams.height, WindowManager.LayoutParams.WRAP_CONTENT);
    }

    @MediumTest
public void testPreconditions() {
    assertNotNull("mMainActivity is null", mCallActivity);
   // assertNotNull("mcontactButton is null", mcallButton);
    assertNotNull("msenderMessageEditText is null", moutpuTextView);
    assertNotNull("mcallButton is null", mcallButton);
}
    @MediumTest
    public void testCallButton_labelText() {
        //Verify that mClickMeButton uses the correct string resource
        final String expectedNextButtonText = mCallActivity.getString(R.string.contact);
        final String actualNextButtonText = mcallButton.getText().toString();
        final String expectedEditText = meditNumberPhoneText.getText().toString();
        assertEquals(expectedNextButtonText, actualNextButtonText);
        assertEquals(expectedEditText, actualNextButtonText);
    }

    @MediumTest
    public void testInfoTextView_layout() {
        //Retrieve the top-level window decor view
        final View decorView = mCallActivity.getWindow().getDecorView();

        //Verify that the mInfoTextView is on screen and is not visible
        ViewAsserts.assertOnScreen(decorView, moutpuTextView);
        assertTrue(View.GONE == moutpuTextView.getVisibility());
    }

    @MediumTest
    public void testInfoTextViewText_isEmpty() {
        //Verify that the mInfoTextView is initialized with the correct default value
        assertEquals("", moutpuTextView.getText());
    }

    @MediumTest
    public void testCallButton_clickButtonAndExpectInfoText() {
        String expectedInfoText = mCallActivity.getString(R.string.contact);
        //Perform a click on mClickMeButton
        TouchUtils.clickView(this, mcallButton);
        //Verify the that mClickMeButton was clicked. mInfoTextView is visible and contains
        //the correct text.
        assertTrue(View.VISIBLE == moutpuTextView.getVisibility());
        assertEquals(expectedInfoText, moutpuTextView.getText());
    
    }
    
    @MediumTest
    public void testContactButton_clickButtonAndExpectInfoText() {
        String expectedInfoText = mCallActivity.getString(R.string.contact);
        //Perform a click on mClickMeButton
        TouchUtils.clickView(this, mcallButton);
        //Verify the that mClickMeButton was clicked. mInfoTextView is visible and contains
        //the correct text.
        assertTrue(View.VISIBLE == moutpuTextView.getVisibility());
        assertEquals(expectedInfoText, moutpuTextView.getText());
    }

}
