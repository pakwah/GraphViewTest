package com.practice.baihua.graphviewapp;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;

import com.jjoe64.graphview.BarGraphView;
import com.jjoe64.graphview.CustomLabelFormatter;
import com.jjoe64.graphview.GraphView;
import com.jjoe64.graphview.GraphViewSeries;

public class MainFragment extends Fragment {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_main, container, false);
        GraphViewSeries exampleSeries = new GraphViewSeries(new GraphView.GraphViewData[]{
                new GraphView.GraphViewData(1, 2.0d), new GraphView.GraphViewData(2, 3.0d), new GraphView.GraphViewData(3, 4.0d),
                new GraphView.GraphViewData(4, 7.0d), new GraphView.GraphViewData(5, 9.0d),
                new GraphView.GraphViewData(6, 5.0d), new GraphView.GraphViewData(7, 4.0d)
        });

        GraphView graphView = new BarGraphView(getActivity(), "BarGraphTest");

        //set horizontal labels
        graphView.setHorizontalLabels(new String[]{"Mon", "Tue", "Wed", "Thu", "Fri", "Sat", "Sun"});
        graphView.setCustomLabelFormatter(new CustomLabelFormatter() {
            @Override
            public String formatLabel(double v, boolean b) {
                if(b) {
                    switch((int)v) {
                        case 1:
                            return "Mon";
                        case 2:
                            return "Tue";
                        case 3:
                            return "Wed";
                        case 4:
                            return "Thu";
                        case 5:
                            return "Fri";
                        case 6:
                            return "Sat";
                        case 7:
                            return "Sun";
                        default:
                            return null;
                    }
                }
                return null;
            }
        });

        graphView.addSeries(exampleSeries);
        FrameLayout layout = (FrameLayout) root.findViewById(R.id.frame);
        layout.addView(graphView);
        return root;
    }
}
