package com.example.prototipov11.UI.Perfil;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.prototipov11.R;
import com.twitter.sdk.android.core.Twitter;
import com.twitter.sdk.android.tweetui.TweetTimelineRecyclerViewAdapter;
import com.twitter.sdk.android.tweetui.UserTimeline;

public class TwitterFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        //teste

        View view = inflater.inflate(R.layout.twitter_fragment, container, false);

        Twitter.initialize(getContext());

        final RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.recycler);

        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        UserTimeline userTimeline = new UserTimeline.Builder().screenName("cbmscoficial").build();

        final TweetTimelineRecyclerViewAdapter adapter =
                new TweetTimelineRecyclerViewAdapter.Builder(getContext())
                        .setTimeline(userTimeline)
                        .setViewStyle(R.style.tw__TweetLightWithActionsStyle)
                        .build();

        recyclerView.setAdapter(adapter);

        return view;
    }
}
