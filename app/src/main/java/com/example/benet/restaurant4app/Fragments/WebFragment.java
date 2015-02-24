package com.example.benet.restaurant4app.Fragments;

import android.app.Activity;
import android.net.Uri;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.example.benet.restaurant4app.R;
import com.example.benet.restaurant4app.Utils.Constants;

public class WebFragment extends Fragment {

    private String url;

    public WebFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_web, container, false);
    }


    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        WebView web=(WebView)getActivity().findViewById(R.id.fragment_web);
        
        web.loadUrl(url);
        web.setWebViewClient(new WebViewClient() {
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                view.loadUrl(url);
                return true;
            }
        });

    }



    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);


        Bundle arg=getArguments();
        if(arg!=null){
            url=arg.getString(Constants.SEND_URL);
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
    }



}
