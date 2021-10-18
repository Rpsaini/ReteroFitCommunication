package com.wallet.retrofitapi.api;

public interface RxAPICallback<P> {
    void onSuccess(P t);

    void onFailed(Throwable throwable);
}

