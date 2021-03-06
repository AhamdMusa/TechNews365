package com.brainybrains.technews365.ui.gallery;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.brainybrains.technews365.R;

public class GalleryFragment extends Fragment {

    private GalleryViewModel galleryViewModel;
    public WebView webView;
    public String url="https://technews365.info/category/ccna-tips/";

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        galleryViewModel =
                new ViewModelProvider(this).get(GalleryViewModel.class);
        View root = inflater.inflate(R.layout.fragment_gallery, container, false);
        webView=root.findViewById(R.id.homeweb);
        galleryViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(String s) {
                webView.setWebViewClient(new WebViewClient());
                webView.loadUrl(url);
            }

        });
        return root;
    }
}