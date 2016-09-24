package id.sch.smktelkom_mlg.learn.advancedwidget1;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.InputType;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    LinearLayout llMain;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final LinearLayout llMain = (LinearLayout) findViewById(R.id.Layout);
        addEditText(llMain);

      /*  */

        Button bProses = new Button(this);
        bProses.setText("Proses");
        llMain.addView(bProses);
        final TextView tvHasil = new TextView(this);
        llMain.addView(tvHasil);

        bProses.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                doProcess(llMain);
            }
        });

    }

    private void addEditText(LinearLayout llMain) {
        for (int i = 1; i <= 5; i++) {
            EditText etName = new EditText(this);
            llMain.addView(etName);
            etName.setHint("Isikan Nama Anak");

            final EditText etUmur = new EditText(this);
            llMain.addView(etUmur);
            etUmur.setHint("Isikan umur anak");
            etUmur.setInputType(InputType.TYPE_CLASS_NUMBER);
        }
    }

    private void doProcess(LinearLayout llMain) {
        String hasil = "";
        for (int a = 0; a < 5; a++) ;
        {
            int a = 0;
            EditText etName = (EditText) llMain.getChildAt(a * 2);
            EditText etUmur = (EditText) llMain.getChildAt((a * 2) + 1);

            String nama = etName.getText().toString().trim();
            String umur = etUmur.getText().toString();

            if (umur.isEmpty())
                umur = "0";
            if (!nama.isEmpty())
                hasil += "Anak ke-" + (a + 1) + ": " + nama + " umur " + umur + " tahun\n";

        }

        TextView tvHasil = (TextView) llMain.getChildAt(11);
        tvHasil.setText(hasil);

    }

}
