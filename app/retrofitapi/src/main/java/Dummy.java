import okhttp3.MultipartBody;

public class Dummy {



    //  private void uploadImageToServer()
//    {
//        File file = new File(imagePathfront);
//        if (file != null)
//            {
//            Observable<Response<ServerResponse>> responseObservable = null;
//            AddEventInterface contestService = ApiProduction.getInstance(this).provideService(AddEventInterface.class);
//
//           Request Body requestBody = RequestBody.create(MediaType.parse("*/*"), file);
//            MultipartBody.Part body = MultipartBody.Part.createFormData("payment_receipt", file.getName(), requestBody);
//            RequestBody filename = RequestBody.create(MediaType.parse("text/plain"), file.getName());
//
//
//            RequestBody DeviceToken = RequestBody.create(MediaType.parse("text/plain"), getDeviceToken());
//            RequestBody Version = RequestBody.create(MediaType.parse("text/plain"), getAppVersion());
//            RequestBody PlatForm = RequestBody.create(MediaType.parse("text/plain"), "Android");
//
//            RequestBody currency = RequestBody.create(MediaType.parse("text/plain"), "INR");
//            RequestBody amount = RequestBody.create(MediaType.parse("text/plain"), ed_amount.getText().toString());
//            RequestBody reference = RequestBody.create(MediaType.parse("text/plain"), txt_deposit_code.getText().toString());
//            RequestBody remarks = RequestBody.create(MediaType.parse("text/plain"), ed_remarks.getText().toString());
//
//            RequestBody token = RequestBody.create(MediaType.parse("text/plain"), savePreferences.reterivePreference(DepositeInrActivity.this, DefaultConstants.token) + "");
//            String RtokenHeader = getDeviceToken();
//
//            responseObservable = contestService.uploadImage(token, DeviceToken, Version, PlatForm, getXapiKey(), RtokenHeader, body, filename,currency,amount,reference,remarks);
//            ProgressDialog progressDialog = new ProgressDialog(this);
//            progressDialog.setTitle("Please wait..");
//            progressDialog.setCancelable(false);
//            progressDialog.show();
//
//
//            RxAPICallHelper.call(responseObservable, new RxAPICallback<Response<ServerResponse>>() {
//                @Override
//                public void onSuccess(Response<ServerResponse> t) {
//                    progressDialog.dismiss();
//                    if (t.body().isStatus()) {
//                        imagePathfront="";
//                        ed_amount.setText("");
//                        ed_remarks.setText("");
//                        image_upload.setImageResource(R.drawable.payment_receipt);
//
//                        alertDialogs.alertDialog(DepositeInrActivity.this, getResources().getString(R.string.app_name), t.body().getMsg(), "ok", "", new DialogCallBacks() {
//                            @Override
//                            public void getDialogEvent(String buttonPressed) {
//                                finish();
//                            }
//                        });
//
//
//                    } else {
//                        alertDialogs.alertDialog(DepositeInrActivity.this, getResources().getString(R.string.app_name), t.body().getMsg(), "ok", "", new DialogCallBacks() {
//                            @Override
//                            public void getDialogEvent(String buttonPressed) {
//                            }
//                        });
//                    }
//                }
//
//                @Override
//                public void onFailed(Throwable throwable) {
//
//                }
//
//            });
//        }
//    }

}
