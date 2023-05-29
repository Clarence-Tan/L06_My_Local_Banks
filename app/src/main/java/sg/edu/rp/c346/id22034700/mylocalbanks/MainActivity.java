package sg.edu.rp.c346.id22034700.mylocalbanks;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    TextView tvDBS;
    TextView tvOCBC;
    TextView tvUOB;

    String wordClicked = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvDBS = findViewById(R.id.textViewDBS);
        tvOCBC = findViewById(R.id.textViewOCBC);
        tvUOB = findViewById(R.id.textViewUOB);

        registerForContextMenu(tvDBS);
        registerForContextMenu(tvOCBC);
        registerForContextMenu(tvUOB);

    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v,
                                    ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);

        if (v == tvDBS) {
            wordClicked = "DBS";
        } else if (v == tvOCBC) {
            wordClicked = "OCBC";
        } else if (v == tvUOB) {
            wordClicked = "UOB";
        }

        menu.add(0,0,0,"Website");
        menu.add(0,1,1,"Contact the bank");
        menu.add(0,2,2,"Toggle Favourite");
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        if(wordClicked.equalsIgnoreCase("DBS")) {
            if (item.getItemId() == 0) {
                Intent intentCall = new Intent(Intent.ACTION_VIEW, Uri.parse(getString(R.string.dbsWebsite)));
                startActivity(intentCall);
                return true;
            } else if (item.getItemId() == 1) {
                Intent intentCall = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:"+getString(R.string.dbsNum)));
                startActivity(intentCall);
                return true;
            } else if (item.getItemId() == 2) {
                if (tvDBS.getCurrentTextColor() == getResources().getColor(R.color.black)) {
                    tvDBS.setTextColor(getResources().getColor(R.color.red));
                } else if (tvDBS.getCurrentTextColor() == getResources().getColor(R.color.red)) {
                    tvDBS.setTextColor(getResources().getColor(R.color.black));
                }
            }
        } else if (wordClicked.equalsIgnoreCase("OCBC")) {
            if (item.getItemId() == 0) {
                Intent intentCall = new Intent(Intent.ACTION_VIEW, Uri.parse(getString(R.string.ocbcWebsite)));
                startActivity(intentCall);
                return true;
            } else if (item.getItemId() == 1) {
                Intent intentCall = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:"+getString(R.string.ocbcNum)));
                startActivity(intentCall);
                return true;
            } else if (item.getItemId() == 2) {
                if (tvOCBC.getCurrentTextColor() == getResources().getColor(R.color.black)) {
                    tvOCBC.setTextColor(getResources().getColor(R.color.red));
                } else if (tvOCBC.getCurrentTextColor() == getResources().getColor(R.color.red)) {
                    tvOCBC.setTextColor(getResources().getColor(R.color.black));
                }
            }
        } else if (wordClicked.equalsIgnoreCase("UOB")) {
            if (item.getItemId() == 0) {
                Intent intentCall = new Intent(Intent.ACTION_VIEW, Uri.parse(getString(R.string.uobWebsite)));
                startActivity(intentCall);
                return true;
            } else if (item.getItemId() == 1) {
                Intent intentCall = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:"+getString(R.string.uobNum)));
                startActivity(intentCall);
                return true;
            } else if (item.getItemId() == 2) {
                if (tvUOB.getCurrentTextColor() == getResources().getColor(R.color.black)) {
                    tvUOB.setTextColor(getResources().getColor(R.color.red));
                } else if (tvUOB.getCurrentTextColor() == getResources().getColor(R.color.red)) {
                    tvUOB.setTextColor(getResources().getColor(R.color.black));
                }
            }
        }
        return super.onContextItemSelected(item); //pass menu item to the superclass implementation
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here.
        int id = item.getItemId();

        if (id == R.id.EnglishSelection) {
            tvDBS.setText(getString(R.string.dbs));
            tvOCBC.setText(getString(R.string.ocbc));
            tvUOB.setText(getString(R.string.uob));
            return true;
        } else if (id == R.id.italianSelection) {
            tvDBS.setText(getString(R.string.dbsCn));
            tvOCBC.setText(getString(R.string.ocbcCn));
            tvUOB.setText(getString(R.string.uobCn));
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

}