package code;

class RpcResponse {
    private int id;
    void setData(int _id) {
        id = _id;
    }
    int getData() {
        return id;
    }
}
public class DefaultFuture {
    private RpcResponse rpcResponse;
    private volatile boolean isSucceed = false;
    private final Object lock = new Object();
    private Runnable callback;

    public void getRpcResponse(Runnable callback) {
        synchronized (lock) {
            if (isSucceed) {
                callback.run();
            } else {
                this.callback = callback;
            }
        }
    }

    public void setResponse(RpcResponse response) {
        synchronized (lock) {
            if (isSucceed) {
                return;
            }
            this.rpcResponse = response;
            this.isSucceed = true;
            if (callback != null) {
                callback.run();
            }
        }
    }

    public static void main(String[] args) {
        DefaultFuture future = new DefaultFuture();
        future.getRpcResponse(() -> System.out.println("Received response: " + future.rpcResponse.getData()));

        new Thread(() -> {
            // 模拟耗时操作
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            // 模拟得到响应
            RpcResponse response = new RpcResponse();
//            response.setData("Response Data");
            future.setResponse(response);
        }).start();

        System.out.println("Request sent, can do other things now");
    }
}

