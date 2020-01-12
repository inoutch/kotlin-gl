#import <QuartzCore/QuartzCore.h>
#import "EAGLView.h"

@implementation EAGLView

+ (Class)layerClass
{
    return [CAEAGLLayer class];
}

@end
