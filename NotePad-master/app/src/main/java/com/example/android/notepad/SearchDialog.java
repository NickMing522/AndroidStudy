package com.example.android.notepad;
import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.database.Cursor;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class SearchDialog extends DialogFragment {
    private Button cancel,search;
    private EditText searchText;
    private String content;
    private static final String[] PROJECTION = new String[] {
            NotePad.Notes._ID,

    };

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        View view= LayoutInflater.from(getActivity()).inflate(R.layout.search_dialog,null);

        searchText=(EditText)view.findViewById(R.id.searchText);
        searchText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                content=charSequence.toString();

            }

            @Override
            public void afterTextChanged(Editable editable) {

            }


        });

        //查找
        search=(Button)view.findViewById(R.id.search);
        search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (content.length()>0){
                    Cursor cursor = getActivity().managedQuery(
                            getActivity().getIntent().getData(),            // Use the default content URI for the provider.
                            PROJECTION,                       // Return the note ID and title for each note.
                            NotePad.Notes.COLUMN_NAME_TITLE+" like ?",                             // No where clause, return all records.
                            new String[]{content},                             // No where clause, therefore no where column values.
                            NotePad.Notes.DEFAULT_SORT_ORDER  // Use the default sort order.
                    );
                        startActivity(SearchNote.newIntent(getActivity(),content));
                        dismiss();

                }
            }
        });

        //退出
        cancel=(Button) view.findViewById(R.id.cancel);
        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dismiss();
            }
        });
        return new AlertDialog.Builder(getActivity()).setView(view).show();
    }
}
