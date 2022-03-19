#include <jni.h>
#include <string>
#include <cstring>
#include <cstdio>

using namespace std;
#ifdef __cplusplus
extern "C" {
#endif
#define CALC_MAX_LENGTH  (2000)

enum calc_error {
    NO_ERROR = 0,
    EXPR_ERROR = -1,
    EXPR_TOO_LONG = -2
};

extern char* calc(const char* expr);
#ifdef __cplusplus
}
#endif

extern "C"
JNIEXPORT jstring JNICALL
Java_com_hujunyao_cumtcal_MainActivity_trans(JNIEnv *env, jclass clazz, jstring str) {
    const char *input_char = (env)->GetStringUTFChars(str,nullptr);
    return env->NewStringUTF(calc(input_char));
//    const char *input_char = (env)->GetStringUTFChars(str, nullptr);
//    string output_str = input_char;
//    string output = "Hello, " + output_str;
//    return env->NewStringUTF(output.c_str());
}