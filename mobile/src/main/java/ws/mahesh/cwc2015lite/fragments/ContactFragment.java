package ws.mahesh.cwc2015lite.fragments;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import ws.mahesh.cwc2015lite.R;

/**
 * Created by Mahesh on 2/1/2015.
 */
public class ContactFragment extends Fragment {
    Button button;
    EditText sbj;
    EditText messageBody;

    public ContactFragment() {
        // Required empty public constructor
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_contact, container, false);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        sbj = (EditText) getActivity().findViewById(R.id.subject);
        messageBody = (EditText) getActivity().findViewById(R.id.messageBody);
        button = (Button) getActivity().findViewById(R.id.button);

        button.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                if (messageBody.length() > 5 && sbj.length() > 5) {

                    String subject = sbj.getText().toString();
                    String message = messageBody.getText().toString();
                    String to = "app-dev@worldcup15.co";

                    Intent emailIntent = new Intent(Intent.ACTION_SEND);
                    emailIntent.setData(Uri.parse("mailto:"));
                    emailIntent.setType("message/rfc822");
                    emailIntent.putExtra(Intent.EXTRA_EMAIL, new String[]{to});
                    emailIntent.putExtra(Intent.EXTRA_SUBJECT, subject);
                    emailIntent.putExtra(Intent.EXTRA_TEXT, message);
                    startActivity(Intent.createChooser(emailIntent, "Select your Email Provider :"));
                } else
                    Toast.makeText(getActivity(), "Invalid Subject/Message", Toast.LENGTH_LONG).show();

            }
        });
    }

}
