package io.ankit.splitprogress;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.drawable.Drawable;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;

public class SplitProgressDialog extends Dialog {
    LinearLayout parentL;
    private ProgressBar progress1;
    private ProgressBar progress2;
    private ProgressBar progress3;
    private ProgressBar progress4;
    private TextView messageText, percentageText;
    private SplitProgressDialog progressDialog;

    public SplitProgressDialog(final Context context) {
        super(context);
        View view = LayoutInflater.from(context).inflate(R.layout.layout_progress_dialog, null, false);
        messageText = view.findViewById(R.id.messageText);
        percentageText = view.findViewById(R.id.percent);
        progress1 = view.findViewById(R.id.progress1);
        progress2 = view.findViewById(R.id.progress2);
        progress3 = view.findViewById(R.id.progress3);
        progress4 = view.findViewById(R.id.progress4);
        parentL = view.findViewById(R.id.parent_layout);
        parentL.getRootView().setBackgroundColor(context.getResources().getColor(android.R.color.transparent));

        this.setContentView(view);
        this.setCancelable(true);
        this.setOnDismissListener(new OnDismissListener() {
            @Override
            public void onDismiss(DialogInterface dialogInterface) {
                progress1.setProgress(0);
                progress2.setProgress(0);
                progress3.setProgress(0);
                progress4.setProgress(0);
                percentageText.setText("0%");

            }
        });
        this.setOnCancelListener(new OnCancelListener() {
            @Override
            public void onCancel(DialogInterface dialogInterface) {
                progress1.setProgress(0);
                progress2.setProgress(0);
                progress3.setProgress(0);
                progress4.setProgress(0);
                percentageText.setText("0%");
            }
        });

        DisplayMetrics displayMetrics = new DisplayMetrics();
        ((Activity) context).getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        final int height = displayMetrics.heightPixels;
        final int width = displayMetrics.widthPixels;
        this.getWindow().setBackgroundDrawableResource(android.R.color.black);

        this.setOnShowListener(new OnShowListener() {
            @Override
            public void onShow(DialogInterface dialogInterface) {

                progressDialog = new SplitProgressDialog(context);
                progressDialog.getWindow().setLayout(width, 500);

            }
        });
        //this.getWindow().setLayout(width - 60, height / 4);
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
        if (this.isShowing()) {
            super.dismiss();
        } else {
        }
    }

    @Override
    public void setOnShowListener(OnShowListener listener) {
        super.setOnShowListener(listener);
    }

    @Override
    public void setOnDismissListener(OnDismissListener listener) {
        super.setOnDismissListener(listener);
    }

    public void resizeDialog(int width, int height) {
        this.getWindow().setLayout(width, height);

    }

    public void setBackgroundColor(int resId) {
        this.getWindow().setBackgroundDrawableResource(resId);

    }

    public void setBackgroundColor(Drawable drawable) {
        this.getWindow().setBackgroundDrawable(drawable);

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

    public void setProgressDrawable(Drawable progressDrawable) {
        progress1.setProgressDrawable(progressDrawable);
        progress2.setProgressDrawable(progress1.getProgressDrawable());
        progress3.setProgressDrawable(progress2.getProgressDrawable());
        progress4.setProgressDrawable(progress3.getProgressDrawable());

    }

    @Override
    public void setTitle(int titleId) {
        messageText.setText(titleId);
    }

    public void setTitle(String title) {
        messageText.setText(title);
    }
}
