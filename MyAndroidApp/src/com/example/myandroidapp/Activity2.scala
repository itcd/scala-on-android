package com.example.myandroidapp

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import android.view.View;
import android.widget.EditText;

object Activity2 extends Activity {
  var EXTRA_MESSAGE2="com.mycompany.myfirstapp.MESSAGE2"
}

class Activity2 extends Activity {
  
    override def onCreate(savedInstanceState : Bundle) : Unit = {
      super.onCreate(savedInstanceState)
      setContentView(R.layout.activity_activity2)
            
      // Get the message from the intent
	    val intent = getIntent()
	    val message = intent.getStringExtra(MainActivity.EXTRA_MESSAGE)

	    // Create the text view
	    val textView = findViewById(R.id.text_view).asInstanceOf[TextView]
	    textView.setTextSize(40)
	    textView.setText(message)
    }
   
    override def onCreateOptionsMenu(menu : Menu) : Boolean = {
            getMenuInflater().inflate(R.menu.activity2, menu)
            return true
    }
    
    override def onOptionsItemSelected(item : MenuItem) : Boolean = {
    		if(item.getItemId() == R.id.action_settings) true 
    		else super.onOptionsItemSelected(item)
    }
    
    def sendMessage2(view:View):Unit= {
	    val intent = new Intent(this, classOf[MainActivity]);
	    val editText = findViewById(R.id.edit_message2).asInstanceOf[EditText];
	    val message = editText.getText().toString();
	    intent.putExtra(Activity2.EXTRA_MESSAGE2, message);
	    startActivity(intent);
	}
}
