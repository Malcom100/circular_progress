package adneom.circularprogressbar_poc;

import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ProgressBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView txtCounter;
    private ProgressBar circularProgressBar;
    private TextView txtCounter_2;
    private ProgressBar circularProgressBar_2;
    private int pStatus = 0;
    private int pStatus_2 = 0;
    private Handler handler = new Handler();
    private Handler handler_2 = new Handler();
    private int totalTime = 31;
    private int totalTime_2 = 31;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.circular);
        setContentView(R.layout.circular_2);

        //one();
        two();
        three();
    }

    private void one() {
        txtCounter = (TextView) findViewById(R.id.counter);
        circularProgressBar = (ProgressBar) findViewById(R.id.progressBar);

        if (txtCounter != null && circularProgressBar != null) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    while (pStatus < totalTime) {
                        handler.post(new Runnable() {
                            @Override
                            public void run() {
                                circularProgressBar.setProgress(pStatus);
                                String secondes = pStatus < 1 ? " seconde" : " secondes";
                                txtCounter.setText(pStatus + secondes);
                            }
                        });
                        try {
                            Thread.sleep(1000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                            Log.e("Adneom", e.getMessage());
                        }
                        pStatus++;
                    }
                }
            }).start();
        }
    }

    private void two() {
        txtCounter = (TextView) findViewById(R.id.txt);
        circularProgressBar = (ProgressBar) findViewById(R.id.circularProgressbar);

        if (txtCounter != null && circularProgressBar != null) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    while (pStatus < totalTime) {
                        handler.post(new Runnable() {
                            @Override
                            public void run() {
                                circularProgressBar.setProgress(pStatus);
                                String str = pStatus < 10 ? String.format("00:0%d", pStatus) : String.format("00:%d", pStatus);
                                txtCounter.setText(str);
                            }
                        });
                        try {
                            Thread.sleep(1000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                            Log.e("Adneom", e.getMessage());
                        }
                        pStatus++;
                    }
                }
            }).start();
        }
    }

    private void three() {
        txtCounter_2 = (TextView) findViewById(R.id.txt_2);
        circularProgressBar_2 = (ProgressBar) findViewById(R.id.progressBar2);

        if (txtCounter_2 != null && circularProgressBar_2 != null) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    while (pStatus_2 < totalTime_2) {
                        handler_2.post(new Runnable() {
                            @Override
                            public void run() {
                                circularProgressBar_2.setProgress(pStatus_2);
                                String str = pStatus_2 < 2 ? " seconde" : " secondes";
                                txtCounter_2.setText(pStatus_2 + str);
                            }
                        });
                        try {
                            Thread.sleep(1000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                            Log.e("Adneom", e.getMessage());
                        }
                        pStatus_2++;
                    }
                }
            }).start();
        }
    }
}
