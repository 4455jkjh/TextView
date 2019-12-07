package com.a4455jkjh.textview;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.a4455jkjh.view.EditText;
import com.a4455jkjh.view.TextView;
import com.a4455jkjh.view.highlighting.SmaliHighlighting;

public class MainActivity extends Activity {
    private EditText textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        textView = new EditText(this);
        textView.setHighlighting(new SmaliHighlighting());
        setContentView(textView);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onPrepareOptionsMenu(Menu menu) {
        menu.findItem(R.id.undo).setEnabled(textView.undoable());
        menu.findItem(R.id.redo).setEnabled(textView.redoable());
        return super.onPrepareOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.undo:
                textView.undo();
                break;
            case R.id.redo:
                textView.redo();
                break;
            default:
                return super.onOptionsItemSelected(item);
        }
        return true;
    }
}
