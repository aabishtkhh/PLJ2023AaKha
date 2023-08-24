

export type Prop = { /*we can also export this object seperately*/
    id?: number;
    name: string;    
    rating : number; 
    description : string;
    length : number;
    image_url : string;
    ghibli : boolean;
    disney : boolean;
    personalOpinion : string
}

export function ReviewProp(props: Prop) {
    return (
        <>
        <div>{props.id}</div>
        <div>{props.name}</div>
        <div>{props.rating}</div>
        <div>{props.description}</div>
        <div>{props.length}</div>
        <div>{props.image_url}</div>
        <div>{props.ghibli}</div>
        <div>{props.disney}</div>
        <div>{props.personalOpinion}</div>
      </>
    );
}

export default ReviewProp;