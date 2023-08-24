import ReviewProp, { Prop } from "./ReviewProp"

export const reviewData = [
    {
      "id": 1,
      "name": "Margalo",
      "rating": 47,
      "description": "Cras mi pede, malesuada in, imperdiet et, commodo vulputate, justo. In blandit ultrices enim. Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Proin interdum mauris non ligula pellentesque ultrices.",
      "length": 69,
      "image_url": "data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAABAAAAAQCAYAAAAf8/9hAAAAB...",
      "ghibli": false,
      "disney": false,
      "personalOpinion": "In tempor, turpis nec euismod scelerisque, quam turpis adipiscing lorem, vitae mattis nibh ligula nec sem. Duis aliquam convallis nunc. Proin at turpis a pede posuere nonummy. Integer non velit. Donec diam neque, vestibulum eget, vulputate ut, ultrices vel, augue. Vestibulum ante ipsum primis in faucibus orci luctus et ultrices posuere cubilia Curae; Donec pharetra, magna vestibulum aliquet ultrices, erat tortor sollicitudin mi, sit amet lobortis sapien sapien non mi. Integer ac neque. Duis bibendum. Morbi non quam nec dui luctus rutrum. Nulla tellus."
    },
    {
      "id": 2,
      "name": "Aurel",
      "rating": 23,
      "description": "Suspendisse potenti. Nullam porttitor lacus at turpis. Donec posuere metus vitae ipsum. Aliquam non mauris. Morbi non lectus. Aliquam sit amet diam in magna bibendum imperdiet. Nullam orci pede, venenatis non, sodales sed, tincidunt eu, felis. Fusce posuere felis sed lacus. Morbi sem mauris, laoreet ut, rhoncus aliquet, pulvinar sed, nisl. Nunc rhoncus dui vel sem.",
      "length": 88,
      "image_url": "data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAABAAAAAQCAYAAAAf8/9hAAAAB...",
      "ghibli": true,
      "disney": false,
      "personalOpinion": "Cras pellentesque volutpat dui. Maecenas tristique, est et tempus semper, est quam pharetra magna, ac consequat metus sapien ut nunc. Vestibulum ante ipsum primis in faucibus orci luctus et ultrices posuere cubilia Curae; Mauris viverra diam vitae quam."
    },
    {
      "id": 3,
      "name": "Debi",
      "rating": 22,
      "description": "Suspendisse potenti. Cras in purus eu magna vulputate luctus.",
      "length": 95,
      "image_url": "data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAABAAAAAQCAYAAAAf8/9hAAAAB...",
      "ghibli": true,
      "disney": false,
      "personalOpinion": "Nulla suscipit ligula in lacus. Curabitur at ipsum ac tellus semper interdum. Mauris ullamcorper purus sit amet nulla. Quisque arcu libero, rutrum ac, lobortis vel, dapibus at, diam. Nam tristique tortor eu pede."
    },
    {
      "id": 4,
      "name": "Ammamaria",
      "rating": 52,
      "description": "Maecenas ut massa quis augue luctus tincidunt. Nulla mollis molestie lorem. Quisque ut erat. Curabitur gravida nisi at nibh.",
      "length": 79,
      "image_url": "data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAABAAAAAQCAYAAAAf8/9hAAAAB...",
      "ghibli": true,
      "disney": false,
      "personalOpinion": "Nulla tellus. In sagittis dui vel nisl. Duis ac nibh. Fusce lacus purus, aliquet at, feugiat non, pretium quis, lectus. Suspendisse potenti. In eleifend quam a odio. In hac habitasse platea dictumst. Maecenas ut massa quis augue luctus tincidunt."
    }
]

export function ReviewData() {
  return (
    <>
      {
      reviewData.map((item: Prop) => (
        <ReviewProp
          key={item.id}
          id={item.id}
          name={item.name}
          rating={item.rating}
          description={item.description}
          length={item.length}
          image_url={item.image_url}
          ghibli={item.ghibli}
          disney={item.disney}
          personalOpinion={item.personalOpinion}
        />
      ))
      };
    </>
  );
}

export default ReviewData;
