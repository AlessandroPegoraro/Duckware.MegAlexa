package com.swe.duckware.megalexa;

import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.swe.duckware.megalexa.alexa.Connector;
import java.util.List;

public class AvailableConnectorRecycleViewAdapter extends RecyclerView.Adapter<AvailableConnectorRecycleViewAdapter.ViewHolder> {

    private final List<Connector> mConnector;

    private final ConnectorActivity activity;

    public AvailableConnectorRecycleViewAdapter(List<Connector> connectors,
                                                ConnectorActivity activity) {
        this.mConnector = connectors;
        this.activity = activity;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_item_connector_available, parent, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.connector = mConnector.get(position);

        holder.connectorName.setText( mConnector.get(position).toString() );
        holder.connectorAdd.setOnClickListener(view -> {
            activity.findViewById(R.id.buttonSaveConnectors).setVisibility(View.VISIBLE);

            Connector cn = new Connector(holder.connectorName.getText().toString(), "http://www.url.com");
            activity.addConnectorToActive(cn);
        });
    }

    @Override
    public int getItemCount() {
        return mConnector.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        public final View parentView;
        public final TextView connectorName;
        public final Button connectorAdd;
        public Connector connector;

        public ViewHolder(View itemView) {
            super(itemView);

            this.parentView = itemView;
            this.connectorName = itemView.findViewById(R.id.list_item_activeconnector_name);
            this.connectorAdd = itemView.findViewById(R.id.buttonAddConnector);
        }

        @Override
        public String toString() {
            return super.toString() + " '" + connectorName.getText() + "'";
        }
    }

}