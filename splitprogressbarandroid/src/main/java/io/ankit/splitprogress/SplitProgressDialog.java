package io.ankit.splitprogress;

import android.app.Dialog;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;

public class SplitProgressDialog extends Dialog {
    ProgressBar progress1;
    ProgressBar progress2;
    ProgressBar progress3;
    ProgressBar progress4;
    TextView messageText, percentageText;
    int i;

    public SplitProgressDialog(Context context) {
        super(context);
        View view = LayoutInflater.from(context).inflate(R.layout.layout_progress_dialog, null, false);
        messageText = view.findViewById(R.id.messageText);
        percentageText = view.findViewById(R.id.percent);
        progress1 = view.findViewById(R.id.progress1);
        progress2 = view.findViewById(R.id.progress2);
        progress3 = view.findViewById(R.id.progress3);
        progress4 = view.findViewById(R.id.progress4);
        LinearLayout parentL = view.findViewById(R.id.parent_layout);

        this.setContentView(view);
        this.setTitle("Loading.....");
        this.setCancelable(false);


    }

    @Override
    public void cancel() {
        super.cancel();
    }

    @Override
    public void show() {
        super.show();
    }

    @Override
    public void dismiss() {
        super.dismiss();
    }

    @Override
    public void setCancelable(boolean flag) {
        super.setCancelable(flag);
    }

    public void setProgress(int progress) {
        percentageText.setText(String.valueOf(progress).concat("%"));
        if (progress <= 25) {
            progress1.setProgress(progress * 4);
        } else if (progress >= 25 && progress <= 50) {

            progress2.setProgress((progress - 25) * 4);


        } else if (progress >= 50 && progress <= 75) {

            progress3.setProgress((progress - 50) * 4);


        } else if (progress >= 75 && progress <= 100) {
            progress4.setProgress((progress - 75) * 4);


        }

    }

    @Override
    public void setTitle(int titleId) {
        messageText.setText(titleId);
    }
}
