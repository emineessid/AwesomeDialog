package com.awesomedialog.blennersilva.awesomedialoglibrary;

import android.content.Context;
import android.graphics.PorterDuff;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.view.View;
import android.widget.Button;

import com.awesomedialog.blennersilva.awesomedialoglibrary.interfaces.Closure;

/**
 * Created by blennersilva on 21/08/17.
 */

@SuppressWarnings("WeakerAccess")
public class AwesomeErrorDialog extends AwesomeDialogBuilder<AwesomeErrorDialog> {
    private Button btDialogOk;

    public AwesomeErrorDialog(Context context) {
        super(context);

        setColoredCircle(R.color.dialogErrorBackgroundColor);
        setDialogIconAndColor(R.drawable.ic_dialog_error, R.color.white);
        setButtonBackgroundColor(R.color.dialogErrorBackgroundColor);
        setButtonText(context.getString(R.string.dialog_ok_button));
        setButtonTextColor(R.color.white);
        setCancelable(true);
    }

    {
        btDialogOk = findView(R.id.btDialogOk);
    }

    public AwesomeErrorDialog setErrorButton(@Nullable final Closure selecteOk) {
        btDialogOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (selecteOk != null) {
                    selecteOk.exec();
                }

                hide();
            }
        });
        return this;
    }

    public AwesomeErrorDialog setButtonBackgroundColor(int buttonBackground) {
        if (btDialogOk != null) {
            btDialogOk.getBackground().setColorFilter(ContextCompat.getColor(getContext(), buttonBackground), PorterDuff.Mode.SRC_IN);
            btDialogOk.setVisibility(View.VISIBLE);
        }
        return this;
    }

    public AwesomeErrorDialog setButtonTextColor(int textColor) {
        if (btDialogOk != null) {
            btDialogOk.setTextColor(ContextCompat.getColor(getContext(), textColor));
            btDialogOk.setVisibility(View.VISIBLE);
        }
        return this;
    }

    public AwesomeErrorDialog setButtonText(String text) {
        if (btDialogOk != null) {
            btDialogOk.setText(text);
            btDialogOk.setVisibility(View.VISIBLE);
        }
        return this;
    }

    @Override
    protected int getLayout() {
        return R.layout.dialog_error;
    }
}
