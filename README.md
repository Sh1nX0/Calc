# Calc
просто калькулятор
```
 public void onClick(View v){
        float num1 = 0;
        float num2 = 0;
        float result = 0;
        if(TextUtils.isEmpty(etNum1.getText().toString())
            || TextUtils.isEmpty(etNum2.getText().toString())){
         return;
        }
        num1=Float.parseFloat(etNum1.getText().toString());
        num2=Float.parseFloat(etNum2.getText().toString());
        switch (v.getId()){
            case R.id.btnAdd:
                oper ="+";
                result = num1 + num2;
                break;
        }
      tvResult.setText(num1 + " " + oper + " " + num2 + " = " + result);
 }       
 public boolean onCreateOptionsMenu(Menu menu)
    {
        menu.add(0,1,0,"Reset");
    }
    public boolean onOptionsItemSelected(MenuItem item)
    {
        switch (item.getItemId())
        {
            case 1:
                etNum1.setText("");
                etNum2.setText("");
                tvResult.setText("");
                btnidk.setVisibility(View.INVISIBLE);
                btnw.setVisibility(View.INVISIBLE);
                break; 
         }
        return super.onOptionsItemSelected(item);
     }
