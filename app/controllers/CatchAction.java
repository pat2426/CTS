package controllers;

import Utils.ExceptionMailer;
import play.libs.F;
import play.mvc.Action;
import play.mvc.Http;
import play.mvc.Result;

/**
 * Created by Meaks on 12/5/2015.
 */
public class CatchAction extends Action.Simple{

    public F.Promise<Result> call(Http.Context ctx) {
        try {
            return delegate.call(ctx);
        } catch (Throwable e) {
            ExceptionMailer.send(e);
            throw new RuntimeException(e);
        }
    }
}
