package edu.skku.capstone.justpay;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class RoomActivity extends AppCompatActivity{

    private TextView RoomName, RoomID;
    private ImageButton banBtn, addBtn, changeBtn;

    private RecyclerView tabListView;
    private RoomTabAdapter tabAdapter;

    private ImageView receiptImg;
    private ImageButton prevReceiptBtn, nextReceiptBtn;

    private TextView roomStatus1, roomStatus2, roomStatus3;

    private ListView chartItemListView;
    private RoomChartItemAdapter chartItemAdapter;

    private Button prevStatusBtn, nextStatusBtn;

    private TextView typingStatus;

    private LinearLayout bottomContainer;
    private Button confirmBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_room);

        banBtn = findViewById(R.id.ban_user_btn);
        addBtn = findViewById(R.id.add_user_btn);
        changeBtn = findViewById(R.id.change_user_btn);
        tabListView = findViewById(R.id.room_tab_list);
        chartItemListView = findViewById(R.id.chart_list_view);
        bottomContainer = findViewById(R.id.room_bottom_container);

        setTabs();
        setChartItems();
        setBottomContainer();

        banBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final CharSequence[] items = {"Member1", "Member2", "Member3", "Member4"};

                AlertDialog.Builder builder = new AlertDialog.Builder(RoomActivity.this);
                builder.setTitle("멤버 추방");
                builder.setItems(items, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int pos) {
                        //멤버 추방시 액션
                    }
                });
                builder.show();
            }
        });

        addBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final CharSequence[] items = {"Member1", "Member2", "Member3", "Member4"};

                AlertDialog.Builder builder = new AlertDialog.Builder(RoomActivity.this);
                builder.setTitle("멤버 추가");
                builder.setItems(items, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int pos) {
                        //멤버 추가시 액션
                    }
                });
                builder.show();
            }
        });

        changeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final CharSequence[] items = {"Member1", "Member2", "Member3", "Member4"};

                AlertDialog.Builder builder = new AlertDialog.Builder(RoomActivity.this);
                builder.setTitle("입력멤버 변경");
                builder.setItems(items, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int pos) {
                        //입력멤버 변경시 액션
                    }
                });
                builder.show();
            }
        });

        confirmBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final CharSequence[] items = {"사용자별 결과 확인", "항목별 결과 확인"};

                AlertDialog.Builder builder = new AlertDialog.Builder(RoomActivity.this);
                builder.setTitle("결과 확인");
                builder.setItems(items, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int pos) {  // pos 0: 사용자별 결과 확인, pos 1: 항목별 결과 확인
                        Intent intent;
                        intent = new Intent(RoomActivity.this, ResultActivity1.class);
                        startActivity(intent);
                    }
                });
                builder.show();
            }
        });
    }

    private void setTabs() {
        LinearLayoutManager layoutManager =
                new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        tabListView.setLayoutManager(layoutManager);

        ArrayList<RoomTabItem> tabList = new ArrayList<>();
        tabList.add(new RoomTabItem("05/09 커피"));
        tabList.add(new RoomTabItem("05/08 점심"));

        tabAdapter = new RoomTabAdapter(tabList, new RoomTabAdapter.TabOnClickListener() {
            @Override
            public void onTabClicked(int position) {
                /* Change Tab */
                Toast.makeText(getApplicationContext(), position + "Clicked", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onTabDeleteBtnClicked(int position) {
                /* Remove Tab */
                tabAdapter.removeItem(position);
            }
        });
        tabListView.setAdapter(tabAdapter);

        RoomTabDecoration tabDecoration = new RoomTabDecoration();
        tabListView.addItemDecoration(tabDecoration);
    }

    private void setChartItems() {
        ArrayList<RoomChartItem> chartItemList = new ArrayList<>();
        chartItemList.add(new RoomChartItem("커피", new Integer(3000), new Integer(2)));
        chartItemList.add(new RoomChartItem("쿠키", new Integer(5400), new Integer(3)));
        chartItemList.add(new RoomChartItem("설탕", new Integer(5400), new Integer(3)));

        chartItemAdapter = new RoomChartItemAdapter(chartItemList);
        chartItemListView.setAdapter(chartItemAdapter);
    }

    private void setBottomContainer() {
        LayoutInflater bottomInflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        bottomInflater.inflate(R.layout.room_bottom_confirm, bottomContainer, true);

        confirmBtn = findViewById(R.id.room_result_confirm_btn);
    }
}
