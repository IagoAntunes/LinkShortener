export class BaseResult<T> {
    public isSuccess: boolean;
    public codeError: string;
    public message: string;
    public data?: T;

    private constructor(isSuccess: boolean, message: string, codeError: string, data?: T) {
        this.isSuccess = isSuccess;
        this.message = message;
        this.codeError = codeError;
        if (data !== undefined) {
            this.data = data;
        }
    }

    static success<T>(message: string, data: T): BaseResult<T> {
        return new BaseResult<T>(true, message, '', data);
    }

    static error<T>(message: string, codeError: string): BaseResult<T> {
        return new BaseResult<T>(false, message, codeError!!);
    }
}