package cinderra.myfirstapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;


public class MyActivity extends ActionBarActivity {

    public final static String EXTRA_MESSAGE = "cinderra.myfirstapp.MESSAGE";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        MenuInflater newInflater = getMenuInflater();
        newInflater.inflate(R.menu.main_activity_actions, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        switch (id) {
            case R.id.action_search:
                openSearch();
                return true;

            case R.id.action_settings:
                openSetting();
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }

    }

    public void sendMessage(View view) {
        Intent newIntent = new Intent(this, DisplayMessageActivity.class);
        EditText newEditText = (EditText) findViewById(R.id.edit_message);
        String newMessage = newEditText.getText().toString();
        newIntent.putExtra(EXTRA_MESSAGE, newMessage);
        startActivity(newIntent);
    }
}
