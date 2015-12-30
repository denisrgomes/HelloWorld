package example.denis.rainer.br.helloworld;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.text.Editable;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.net.URI;


public class MainActivity extends Activity {

    private EditText nomeEditText;
    private TextView saudacaoTextView;
    private String saudacao;
    private EditText link;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.nomeEditText = (EditText) findViewById(R.id.nomeEditText);
        this.saudacaoTextView = (TextView) findViewById(R.id.saudacaoTextView);
        this.saudacao = getResources().getString(R.string.saudacao);
        this.link = (EditText) findViewById(R.id.linkEditText);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void surpreenderUsuario(View view) {
        /*
         Editable text = this.nomeEditText.getText();
         this.saudacaoTextView.setText(saudacao+" "+text.toString());
*/

        Intent intent = new Intent(SaudacaoActivity.ACTION_EXIBIR_SAUDACAO);
        intent.addCategory(SaudacaoActivity.CATEGORY_SAUDACAO);

        String text = nomeEditText.getText().toString();
        intent.putExtra(SaudacaoActivity.EXTRA_NOME_USUARIO,text);
        startActivity(intent);
    }

    public void followLink(View view){
        Editable text = this.link.getText();
        if(text.toString().contains("http://")) {
            Uri uri = Uri.parse(text.toString());
            Intent intent = new Intent(Intent.ACTION_VIEW, uri);
            intent.addCategory(Intent.CATEGORY_APP_BROWSER);
            startActivity(intent);
        }
    }
}
